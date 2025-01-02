package com.ruoyi.web.controller.system;

import java.util.List;

import org.apache.commons.collections.ListUtils;
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
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
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
@RequestMapping("/system/info/user")
public class UserInfoController extends BaseController
{
    private String prefix = "system/info/user";



    @Autowired
    private IUserInfoService userInfoService;

    @RequiresPermissions("system:info:user:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:info:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:info:user:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:info:user:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserInfo userInfo)
    {
        UserInfo getUserInfo = new UserInfo();
        userInfo.setInvitationCode(getUserInfo.getInvitationCode());
        List<UserInfo> userInfos = userInfoService.selectUserInfoList(userInfo);
        if(userInfos!=null&& !userInfos.isEmpty()){
            return AjaxResult.warn("邀请码已经被使用，请更换一个吧！");
        }

        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:info:user:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserInfo userInfo = userInfoService.selectUserInfoById(id);
        mmap.put("userInfo", userInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:info:user:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserInfo userInfo) {
        try {
            // 检查传入的 userInfo 是否为空
            if (userInfo == null) {
                return AjaxResult.error("用户信息不能为空");
            }

            String invitationCode = userInfo.getInvitationCode();
            // 检查凭证是否为空
            if (invitationCode == null || invitationCode.trim().isEmpty()) {
                return AjaxResult.warn("邀请码不能为空，请填写一个有效的凭证！");
            }
            // 保留验证
            if(invitationCode.toLowerCase().contains("hellodex")){
                return AjaxResult.warn("邀请码不能包含[hellodex]，请填写一个有效的邀请码！");
            }

            UserInfo userInfoSelect = new UserInfo();
            userInfoSelect.setInvitationCode(invitationCode);
            // 查询是否有相同的凭证已被使用
            List<UserInfo> userInfos = userInfoService.selectUserInfoList(userInfoSelect);
            if (userInfos != null && !userInfos.isEmpty()) {
                return AjaxResult.warn("邀请码已经被使用，还是换一个吧！");
            }

            // 更新用户信息
            return toAjax(userInfoService.updateUserInfo(userInfo));
        } catch (Exception e) {
            // 记录异常日志
            logger.error("编辑保存用户信息时发生异常", e);
            return AjaxResult.error("系统内部错误，请稍后再试");
        }
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:info:user:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userInfoService.deleteUserInfoByIds(ids));
    }
}
