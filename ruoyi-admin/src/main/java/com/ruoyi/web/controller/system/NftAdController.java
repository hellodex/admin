package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ruoyi.system.domain.NftAd;
import com.ruoyi.system.service.INftAdService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * nft轮播图Controller
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/ad/nft")
public class NftAdController extends BaseController
{
    private String prefix = "system/ad/nft";

    @Autowired
    private INftAdService nftAdService;

    @RequiresPermissions("system:ad:nft:view")
    @GetMapping()
    public String ad()
    {
        return prefix + "/ad";
    }

    /**
     * 查询nft轮播图列表
     */
    @RequiresPermissions("system:ad:nft:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NftAd nftAd)
    {
        startPage();
        List<NftAd> list = nftAdService.selectNftAdList(nftAd);
        return getDataTable(list);
    }

    /**
     * 导出nft轮播图列表
     */
    @RequiresPermissions("system:ad:nft:export")
    @Log(title = "nft轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NftAd nftAd)
    {
        List<NftAd> list = nftAdService.selectNftAdList(nftAd);
        ExcelUtil<NftAd> util = new ExcelUtil<NftAd>(NftAd.class);
        return util.exportExcel(list, "nft轮播图数据");
    }

    /**
     * 新增nft轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存nft轮播图
     */
    @RequiresPermissions("system:ad:nft:add")
    @Log(title = "nft轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NftAd nftAd)
    {
        return toAjax(nftAdService.insertNftAd(nftAd));
    }

    /**
     * 修改nft轮播图
     */
    @RequiresPermissions("system:ad:nft:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NftAd nftAd = nftAdService.selectNftAdById(id);
        mmap.put("nftAd", nftAd);
        return prefix + "/edit";
    }

    /**
     * 修改保存nft轮播图
     */
    @RequiresPermissions("system:ad:nft:edit")
    @Log(title = "nft轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NftAd nftAd)
    {
        return toAjax(nftAdService.updateNftAd(nftAd));
    }

    /**
     * 删除nft轮播图
     */
    @RequiresPermissions("system:ad:nft:remove")
    @Log(title = "nft轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nftAdService.deleteNftAdByIds(ids));
    }
}
