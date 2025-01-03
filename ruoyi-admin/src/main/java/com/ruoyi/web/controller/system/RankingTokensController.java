package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Configs;
import com.ruoyi.system.domain.RankingInfo;
import com.ruoyi.system.domain.req.RankingTokensReq;
import com.ruoyi.system.domain.vo.RankingTokensVo;
import com.ruoyi.system.service.IConfigsService;
import com.ruoyi.system.service.IRankingInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.RankingTokens;
import com.ruoyi.system.service.IRankingTokensService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Controller
@RequestMapping("/system/tokens/ranking")
public class RankingTokensController extends BaseController
{
    private String prefix = "system/token/ranking";

    @Autowired
    private IRankingTokensService rankingTokensService;

    @Autowired
    private IRankingInfoService rankingInfoService;

    @Autowired
    private IConfigsService configsService;

    @RequiresPermissions("system:tokens:ranking:view")
    @GetMapping()
    public String tokens(ModelMap mmap)
    {
        mmap.put("configsList", configsService.selectConfigsList(new Configs()));
        mmap.put("rankingInfoList", rankingInfoService.selectRankingInfoList(new RankingInfo()));
        return prefix + "/tokens";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:tokens:ranking:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RankingTokensVo rankingTokens)
    {
        startPage();
        List<RankingTokensVo> list = rankingTokensService.selectRankingTokensList(rankingTokens);
        return getDataTable(list);
    }


    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("configsList", configsService.selectConfigsList(new Configs()));
        mmap.put("rankingInfoList", rankingInfoService.selectRankingInfoList(new RankingInfo()));
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:tokens:ranking:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RankingTokensReq rankingTokensReq)
    {
        RankingTokens rankingTokens = new RankingTokens();
        BeanUtils.copyProperties(rankingTokensReq, rankingTokens);
        rankingTokens.setStartTime(DateUtils.toDateT(rankingTokensReq.getStartTime()));
        rankingTokens.setEndTime(DateUtils.toDateT(rankingTokensReq.getEndTime()));
        return toAjax(rankingTokensService.insertRankingTokens(rankingTokens));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:tokens:ranking:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {

        RankingTokens rankingTokens = rankingTokensService.selectRankingTokensById(id);
        mmap.put("rankingTokens", rankingTokens);
        mmap.put("rankingInfoList", rankingInfoService.selectRankingInfoList(new RankingInfo()));
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:tokens:ranking:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RankingTokensReq rankingTokensReq)
    {
        RankingTokens rankingTokens = new RankingTokens();
        BeanUtils.copyProperties(rankingTokensReq, rankingTokens);
        rankingTokens.setStartTime(DateUtils.toDateT(rankingTokensReq.getStartTime()));
        rankingTokens.setEndTime(DateUtils.toDateT(rankingTokensReq.getEndTime()));
        return toAjax(rankingTokensService.updateRankingTokens(rankingTokens));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:tokens:ranking:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rankingTokensService.deleteRankingTokensByIds(ids));
    }

    @PostMapping( "/getMaxPriorityByRankingId")
    @ResponseBody
    public AjaxResult getMaxPriorityByRankingId(RankingTokensReq rankingTokensReq)
    {
        return AjaxResult.success(rankingTokensService.getMaxPriorityByRankingId(rankingTokensReq.getRankingId()));
    }

}
