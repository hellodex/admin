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
import com.ruoyi.system.domain.TokenMeta;
import com.ruoyi.system.service.ITokenMetaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 代币基本信息Controller
 * 
 * @author ruoyi
 * @date 2024-12-28
 */
@Controller
@RequestMapping("/system/meta")
public class TokenMetaController extends BaseController
{
    private String prefix = "system/meta";

    @Autowired
    private ITokenMetaService tokenMetaService;

    @RequiresPermissions("system:meta:view")
    @GetMapping()
    public String meta()
    {
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
    public String add()
    {
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
}
