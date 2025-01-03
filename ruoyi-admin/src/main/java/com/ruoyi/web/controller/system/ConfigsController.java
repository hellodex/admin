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
import com.ruoyi.system.domain.Configs;
import com.ruoyi.system.service.IConfigsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公链配置Controller
 * 
 * @author ruoyi
 * @date 2025-01-03
 */
@Controller
@RequestMapping("/system/chain/configs")
public class ConfigsController extends BaseController
{
    private String prefix = "system/chain/configs";

    @Autowired
    private IConfigsService configsService;

    @RequiresPermissions("system:configs:view")
    @GetMapping()
    public String configs()
    {
        return prefix + "/configs";
    }

    /**
     * 查询公链配置列表
     */
    @RequiresPermissions("system:configs:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Configs configs)
    {
        startPage();
        List<Configs> list = configsService.selectConfigsList(configs);
        return getDataTable(list);
    }

    /**
     * 导出公链配置列表
     */
    @RequiresPermissions("system:configs:export")
    @Log(title = "公链配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Configs configs)
    {
        List<Configs> list = configsService.selectConfigsList(configs);
        ExcelUtil<Configs> util = new ExcelUtil<Configs>(Configs.class);
        return util.exportExcel(list, "公链配置数据");
    }

    /**
     * 新增公链配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公链配置
     */
    @RequiresPermissions("system:configs:add")
    @Log(title = "公链配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Configs configs)
    {
        return toAjax(configsService.insertConfigs(configs));
    }

    /**
     * 修改公链配置
     */
    @RequiresPermissions("system:configs:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Configs configs = configsService.selectConfigsById(id);
        mmap.put("configs", configs);
        return prefix + "/edit";
    }

    /**
     * 修改保存公链配置
     */
    @RequiresPermissions("system:configs:edit")
    @Log(title = "公链配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Configs configs)
    {
        return toAjax(configsService.updateConfigs(configs));
    }

    /**
     * 删除公链配置
     */
    @RequiresPermissions("system:configs:remove")
    @Log(title = "公链配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(configsService.deleteConfigsByIds(ids));
    }
}
