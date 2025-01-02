package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TokenSearch;
import com.ruoyi.system.service.ITokenSearchService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 开盘池子信息Controller
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Controller
@RequestMapping("/system/token/search")
public class TokenSearchController extends BaseController
{
    private String prefix = "system/token/search";

    @Autowired
    private ITokenSearchService tokenSearchService;

    @RequiresPermissions("system:token:search:view")
    @GetMapping()
    public String search()
    {
        return prefix + "/search";
    }

    /**
     * 查询开盘池子信息列表
     */
    @RequiresPermissions("system:token:search:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenSearch tokenSearch)
    {
        startPage();
        List<TokenSearch> list = tokenSearchService.selectTokenSearchList(tokenSearch);
        return getDataTable(list);
    }

    /**
     * 导出开盘池子信息列表
     */
    @RequiresPermissions("system:token:search:export")
    @Log(title = "开盘池子信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenSearch tokenSearch)
    {
        List<TokenSearch> list = tokenSearchService.selectTokenSearchList(tokenSearch);
        ExcelUtil<TokenSearch> util = new ExcelUtil<TokenSearch>(TokenSearch.class);
        return util.exportExcel(list, "开盘池子信息数据");
    }

    /**
     * 新增开盘池子信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存开盘池子信息
     */
    @RequiresPermissions("system:token:search:add")
    @Log(title = "开盘池子信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenSearch tokenSearch)
    {
        return toAjax(tokenSearchService.insertTokenSearch(tokenSearch));
    }

    /**
     * 修改开盘池子信息
     */
    @RequiresPermissions("system:token:search:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TokenSearch tokenSearch = tokenSearchService.selectTokenSearchById(id);
        mmap.put("tokenSearch", tokenSearch);
        return prefix + "/edit";
    }

    /**
     * 修改保存开盘池子信息
     */
    @RequiresPermissions("system:token:search:edit")
    @Log(title = "开盘池子信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenSearch tokenSearch)
    {
        return toAjax(tokenSearchService.updateTokenSearch(tokenSearch));
    }

    /**
     * 删除开盘池子信息
     */
    @RequiresPermissions("system:token:search:remove")
    @Log(title = "开盘池子信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenSearchService.deleteTokenSearchByIds(ids));
    }


    /**
     * 根据地址查询池子信息
     */
    @PostMapping( "/getSearchByToken")
    @ResponseBody
    public AjaxResult getSearchByToken(@RequestBody TokenSearch tokenSearch)
    {
        TokenSearch maxTvlByToken = tokenSearchService.getMaxTvlByToken(tokenSearch.getBaseAddress());
        return AjaxResult.success(maxTvlByToken);
    }
}
