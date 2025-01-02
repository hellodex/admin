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
import com.ruoyi.system.domain.SubAd;
import com.ruoyi.system.service.ISubAdService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 子广告Controller
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/ad/sub")
public class SubAdController extends BaseController
{
    private String prefix = "system/ad/sub";

    @Autowired
    private ISubAdService subAdService;

    @RequiresPermissions("system:ad:sub:view")
    @GetMapping()
    public String ad()
    {
        return prefix + "/ad";
    }

    /**
     * 查询子广告列表
     */
    @RequiresPermissions("system:ad:sub:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SubAd subAd)
    {
        startPage();
        List<SubAd> list = subAdService.selectSubAdList(subAd);
        return getDataTable(list);
    }

    /**
     * 导出子广告列表
     */
    @RequiresPermissions("system:ad:sub:export")
    @Log(title = "子广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SubAd subAd)
    {
        List<SubAd> list = subAdService.selectSubAdList(subAd);
        ExcelUtil<SubAd> util = new ExcelUtil<SubAd>(SubAd.class);
        return util.exportExcel(list, "子广告数据");
    }

    /**
     * 新增子广告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存子广告
     */
    @RequiresPermissions("system:ad:sub:add")
    @Log(title = "子广告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SubAd subAd)
    {
        return toAjax(subAdService.insertSubAd(subAd));
    }

    /**
     * 修改子广告
     */
    @RequiresPermissions("system:ad:sub:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SubAd subAd = subAdService.selectSubAdById(id);
        mmap.put("subAd", subAd);
        return prefix + "/edit";
    }

    /**
     * 修改保存子广告
     */
    @RequiresPermissions("system:ad:sub:edit")
    @Log(title = "子广告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SubAd subAd)
    {
        return toAjax(subAdService.updateSubAd(subAd));
    }

    /**
     * 删除子广告
     */
    @RequiresPermissions("system:ad:sub:remove")
    @Log(title = "子广告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(subAdService.deleteSubAdByIds(ids));
    }
}
