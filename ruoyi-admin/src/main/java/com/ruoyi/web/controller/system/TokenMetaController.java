package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.R2Uploader;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Configs;
import com.ruoyi.system.domain.RankingInfo;
import com.ruoyi.system.domain.RankingTokens;
import com.ruoyi.system.domain.TokenMeta;
import com.ruoyi.system.domain.TokenSearch;
import com.ruoyi.system.domain.req.TokenMetaReq;
import com.ruoyi.system.service.IConfigsService;
import com.ruoyi.system.service.IRankingInfoService;
import com.ruoyi.system.service.IRankingTokensService;
import com.ruoyi.system.service.ITokenMetaService;
import com.ruoyi.system.service.ITokenSearchService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 代币基本信息Controller
 * 
 * @author ruoyi
 * @date 2024-12-28
 */
@Controller
@RequestMapping("/system/meta")
public class TokenMetaController extends BaseController {

    private final String prefix = "system/meta";

    @Autowired
    private ITokenMetaService tokenMetaService;

    @Autowired
    private IRankingInfoService rankingInfoService;

    @Autowired
    private ITokenSearchService tokenSearchServiceImpl;

    @Autowired
    private IRankingTokensService  rankingTokensServiceImpl;

    @Autowired
    private IConfigsService configsService;

    @Autowired
    private R2Uploader r2Uploader;

    @RequiresPermissions("system:meta:view")
    @GetMapping()
    public String meta(ModelMap mmap)
    {
        mmap.put("configsList", configsService.selectConfigsList(new Configs()));
        return prefix + "/meta";
    }

    /**
     * 查询代币基本信息列表
     */
    @RequiresPermissions("system:meta:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenMeta tokenMeta)
    {
        startPage();
        List<TokenMeta> list = tokenMetaService.selectTokenMetaList(tokenMeta);
        return getDataTable(list);
    }

    /**
     * 导出代币基本信息列表
     */
    @RequiresPermissions("system:meta:export")
    @Log(title = "代币基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenMeta tokenMeta)
    {
        List<TokenMeta> list = tokenMetaService.selectTokenMetaList(tokenMeta);
        ExcelUtil<TokenMeta> util = new ExcelUtil<TokenMeta>(TokenMeta.class);
        return util.exportExcel(list, "代币基本信息数据");
    }

    /**
     * 新增代币基本信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<RankingInfo> rankingInfos = rankingInfoService.selectRankingInfoList(new RankingInfo());
        mmap.put("rankingInfos", rankingInfos);
        return prefix + "/add";
    }

    /**
     * 新增保存代币基本信息
     */
    @RequiresPermissions("system:meta:add")
    @Log(title = "代币基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenMeta tokenMeta)
    {
        return toAjax(tokenMetaService.insertTokenMeta(tokenMeta));
    }

    @RequiresPermissions("system:meta:add")
    @Log(title = "代币基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/addPlus")
    @ResponseBody
    public AjaxResult addPlus(TokenMetaReq tokenMetaReq) throws IOException{
        TokenMeta tokenMeta = new TokenMeta();
        //添加token
        BeanUtils.copyProperties(tokenMetaReq, tokenMeta);

        TokenMeta tokenMetaResult = tokenMetaService.getTokenMetaByAddressAndChainCode(tokenMeta.getAddress(), tokenMeta.getChainCode());
        if(tokenMetaResult!=null){
            return AjaxResult.warn("token已存在,不允许多次添加！");
        }

        /*MultipartFile file = tokenMetaReq.getFile();
        //上传token logo
        if(!file.isEmpty()){
            //完整的路径
            String key = tokenMetaReq.getChainCode() + "/" +tokenMetaReq.getAddress()+"."+ FileUtils.getFileExtension(file);;
            // 上传文件到R2
            r2Uploader.uploadImg(key,"logo", file);
            tokenMeta.setLogo(key);
        }*/
        tokenMetaService.insertTokenMeta(tokenMeta);

        //添加热搜
        if(StringUtils.isNotNull(tokenMetaReq.getRankId())){
            TokenSearch maxTvlByToken = tokenSearchServiceImpl.getMaxTvlByToken(tokenMetaReq.getAddress());
            if(maxTvlByToken !=null){
                RankingTokens rankingTokens = getRankingTokens(tokenMetaReq, maxTvlByToken);
                rankingTokensServiceImpl.insertRankingTokens(rankingTokens);
            }else {
                System.out.println("没找到token_search");
            }
        }
        return AjaxResult.success();
    }


    private static RankingTokens getRankingTokens(TokenMetaReq tokenMetaReq, TokenSearch maxTvlByToken) {
        RankingTokens rankingTokens = new RankingTokens();
        rankingTokens.setRankingId(tokenMetaReq.getRankId());
        rankingTokens.setSearchId(maxTvlByToken.getId());
        rankingTokens.setChainCode(tokenMetaReq.getChainCode());
        rankingTokens.setPriority(tokenMetaReq.getPriority()==null?0:tokenMetaReq.getPriority());
        rankingTokens.setHot(tokenMetaReq.getHot()==null?0:tokenMetaReq.getHot());
        rankingTokens.setStartTime(DateUtils.toDateT(tokenMetaReq.getStartTime()));
        rankingTokens.setEndTime(DateUtils.toDateT(tokenMetaReq.getEndTime()));
        return rankingTokens;
    }


    /**
     * 修改代币基本信息
     */
    @RequiresPermissions("system:meta:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TokenMeta tokenMeta = tokenMetaService.selectTokenMetaById(id);
        mmap.put("tokenMeta", tokenMeta);
        return prefix + "/edit";
    }

    /**
     * 修改保存代币基本信息
     */
    @RequiresPermissions("system:meta:edit")
    @Log(title = "代币基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenMeta tokenMeta)
    {
        return toAjax(tokenMetaService.updateTokenMeta(tokenMeta));
    }

    /**
     * 删除代币基本信息
     */
    @RequiresPermissions("system:meta:remove")
    @Log(title = "代币基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenMetaService.deleteTokenMetaByIds(ids));
    }

    /**
     * 上传LOGO图片
     */
    @PostMapping("/importImg")
    @Log(title = "代币logo上传", businessType = BusinessType.IMPORT)
    @ResponseBody
    public AjaxResult importImg(@RequestParam("image") MultipartFile file,
                                @RequestParam("id") Long id) throws IOException {

        TokenMeta tokenMeta = tokenMetaService.selectTokenMetaById(id);
        //完整的路径
        String key = tokenMeta.getChainCode() + "/" +tokenMeta.getAddress()+"."+ FileUtils.getFileExtension(file);;
        r2Uploader.uploadImg(key,"logo", file);
        // 上传文件到R2
        TokenMeta updateTokenMeta = new TokenMeta();
        updateTokenMeta.setId(id);
        updateTokenMeta.setLogo(key);
        tokenMetaService.updateTokenMeta(updateTokenMeta);
        return AjaxResult.success("上传成功");
    }


    @PostMapping("/uploadLogo")
    @ResponseBody
    public AjaxResult handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("address") String address,
                                   @RequestParam("chainCode") String chainCode) throws IOException {

        if(StringUtils.isEmpty(address)|| StringUtils.isEmpty(chainCode)){
            return AjaxResult.error("address,chainCode参数不能为空");
        }
        //完整的路径
        String key = chainCode + "/" +address+"."+ FileUtils.getFileExtension(file);;
        r2Uploader.uploadImg(key,"logo", file);
        // 上传文件到R2
        return AjaxResult.success(key);
    }

}
