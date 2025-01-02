package com.ruoyi.web.controller.system;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.WithdrawStatus;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtilPlus;
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
import com.ruoyi.system.domain.WithdrawalRecord;
import com.ruoyi.system.service.IWithdrawalRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现记录Controller
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Controller
@RequestMapping("/system/record/withdrawal")
public class WithdrawalRecordController extends BaseController
{
    private String prefix = "system/record/withdrawal";

    @Autowired
    private IWithdrawalRecordService withdrawalRecordService;

    @RequiresPermissions("system:record:withdrawal:view")
    @GetMapping()
    public String record(ModelMap mmap)
    {

        mmap.put("statusList", WithdrawStatus.getEnumObjList());
        return prefix + "/record";
    }

    /**
     * 查询提现记录列表
     */
    @RequiresPermissions("system:record:withdrawal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WithdrawalRecord withdrawalRecord)
    {
        startPage();
        List<WithdrawalRecord> list = withdrawalRecordService.selectWithdrawalRecordList(withdrawalRecord);
        return getDataTable(list);
    }

    /**
     * 导出提现记录列表
     */
    @RequiresPermissions("system:record:withdrawal:export")
    @Log(title = "提现记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WithdrawalRecord withdrawalRecord)
    {
        List<WithdrawalRecord> list = withdrawalRecordService.selectWithdrawalRecordList(withdrawalRecord);
        ExcelUtil<WithdrawalRecord> util = new ExcelUtil<WithdrawalRecord>(WithdrawalRecord.class);
        return util.exportExcel(list, "提现记录数据");
    }

    /**
     * 新增提现记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存提现记录
     */
    @RequiresPermissions("system:record:withdrawal:add")
    @Log(title = "提现记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WithdrawalRecord withdrawalRecord)
    {
        return toAjax(withdrawalRecordService.insertWithdrawalRecord(withdrawalRecord));
    }

    /**
     * 修改提现记录
     */
    @RequiresPermissions("system:record:withdrawal:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WithdrawalRecord withdrawalRecord = withdrawalRecordService.selectWithdrawalRecordById(id);
        mmap.put("withdrawalRecord", withdrawalRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存提现记录
     */
    @RequiresPermissions("system:record:withdrawal:edit")
    @Log(title = "提现记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WithdrawalRecord withdrawalRecord)
    {
        return toAjax(withdrawalRecordService.updateWithdrawalRecord(withdrawalRecord));
    }

    /**
     * 删除提现记录
     */
    @RequiresPermissions("system:record:withdrawal:remove")
    @Log(title = "提现记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(withdrawalRecordService.deleteWithdrawalRecordByIds(ids));
    }


    @RequiresPermissions("system:record:withdrawal:edit")
    @Log(title = "提现记录", businessType = BusinessType.UPDATE)
    @PostMapping("/justDo")
    @ResponseBody
    public AjaxResult justDo(String ids) {

        try {
            if (StringUtils.isEmpty(ids)) {
                return AjaxResult.error("IDs cannot be empty");
            }

            Long[] idsArr = Convert.toLongArray(ids);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ids", idsArr);

            String response = HttpUtilPlus.sendPost("/internal/withdraw/sendTransfer", jsonObject.toJSONString());
            JSONObject jsonResponse = JSON.parseObject(response);

            Integer code = jsonResponse.getInteger("code");
            if (code == null || code != 200) {
                return AjaxResult.error(jsonResponse.getString("msg"));
            } else {
                return AjaxResult.success();
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            return AjaxResult.error("An error occurred: " + e.getMessage());
        }
    }
}
