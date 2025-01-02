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
import com.ruoyi.system.domain.AdWindow;
import com.ruoyi.system.service.IAdWindowService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 弹窗Controller
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/ad/window")
public class AdWindowController extends BaseController
{
    private String prefix = "system/ad/window";

    @Autowired
    private IAdWindowService adWindowService;

    @RequiresPermissions("system:window:view")
    @GetMapping()
    public String window()
    {
        return prefix + "/window";
    }

    /**
     * 查询弹窗列表
     */
    @RequiresPermissions("system:window:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AdWindow adWindow)
    {
        startPage();
        List<AdWindow> list = adWindowService.selectAdWindowList(adWindow);
        return getDataTable(list);
    }

    /**
     * 导出弹窗列表
     */
    @RequiresPermissions("system:window:export")
    @Log(title = "弹窗", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AdWindow adWindow)
    {
        List<AdWindow> list = adWindowService.selectAdWindowList(adWindow);
        ExcelUtil<AdWindow> util = new ExcelUtil<AdWindow>(AdWindow.class);
        return util.exportExcel(list, "弹窗数据");
    }

    /**
     * 新增弹窗
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存弹窗
     */
    @RequiresPermissions("system:window:add")
    @Log(title = "弹窗", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AdWindow adWindow)
    {
        return toAjax(adWindowService.insertAdWindow(adWindow));
    }

    /**
     * 修改弹窗
     */
    @RequiresPermissions("system:window:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AdWindow adWindow = adWindowService.selectAdWindowById(id);
        mmap.put("adWindow", adWindow);
        return prefix + "/edit";
    }

    /**
     * 修改保存弹窗
     */
    @RequiresPermissions("system:window:edit")
    @Log(title = "弹窗", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AdWindow adWindow)
    {
        return toAjax(adWindowService.updateAdWindow(adWindow));
    }

    /**
     * 删除弹窗
     */
    @RequiresPermissions("system:window:remove")
    @Log(title = "弹窗", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(adWindowService.deleteAdWindowByIds(ids));
    }
}
