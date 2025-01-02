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
import com.ruoyi.system.domain.RankingInfo;
import com.ruoyi.system.service.IRankingInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 榜单信息Controller
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Controller
@RequestMapping("/system/info")
public class RankingInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IRankingInfoService rankingInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询榜单信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RankingInfo rankingInfo)
    {
        startPage();
        List<RankingInfo> list = rankingInfoService.selectRankingInfoList(rankingInfo);
        return getDataTable(list);
    }

    /**
     * 导出榜单信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "榜单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RankingInfo rankingInfo)
    {
        List<RankingInfo> list = rankingInfoService.selectRankingInfoList(rankingInfo);
        ExcelUtil<RankingInfo> util = new ExcelUtil<RankingInfo>(RankingInfo.class);
        return util.exportExcel(list, "榜单信息数据");
    }

    /**
     * 新增榜单信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存榜单信息
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "榜单信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RankingInfo rankingInfo)
    {
        return toAjax(rankingInfoService.insertRankingInfo(rankingInfo));
    }

    /**
     * 修改榜单信息
     */
    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RankingInfo rankingInfo = rankingInfoService.selectRankingInfoById(id);
        mmap.put("rankingInfo", rankingInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存榜单信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "榜单信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RankingInfo rankingInfo)
    {
        return toAjax(rankingInfoService.updateRankingInfo(rankingInfo));
    }

    /**
     * 删除榜单信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "榜单信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rankingInfoService.deleteRankingInfoByIds(ids));
    }
}
