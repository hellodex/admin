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
import com.ruoyi.system.domain.Ad;
import com.ruoyi.system.service.IAdService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 广告Controller
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/ad")
public class AdController extends BaseController
{
    private String prefix = "system/ad";

    @Autowired
    private IAdService adService;

    @RequiresPermissions("system:ad:view")
    @GetMapping()
    public String ad()
    {
        return prefix + "/ad";
    }

    /**
     * 查询广告列表
     */
    @RequiresPermissions("system:ad:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Ad ad)
    {
        startPage();
        List<Ad> list = adService.selectAdList(ad);
        return getDataTable(list);
    }

    /**
     * 导出广告列表
     */
    @RequiresPermissions("system:ad:export")
    @Log(title = "广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Ad ad)
    {
        List<Ad> list = adService.selectAdList(ad);
        ExcelUtil<Ad> util = new ExcelUtil<Ad>(Ad.class);
        return util.exportExcel(list, "广告数据");
    }

    /**
     * 新增广告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存广告
     */
    @RequiresPermissions("system:ad:add")
    @Log(title = "广告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Ad ad)
    {
        return toAjax(adService.insertAd(ad));
    }

    /**
     * 修改广告
     */
    @RequiresPermissions("system:ad:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Ad ad = adService.selectAdById(id);
        mmap.put("ad", ad);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告
     */
    @RequiresPermissions("system:ad:edit")
    @Log(title = "广告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Ad ad)
    {
        return toAjax(adService.updateAd(ad));
    }

    /**
     * 删除广告
     */
    @RequiresPermissions("system:ad:remove")
    @Log(title = "广告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(adService.deleteAdByIds(ids));
    }
}
