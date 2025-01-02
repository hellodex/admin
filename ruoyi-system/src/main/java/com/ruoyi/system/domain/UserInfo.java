package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 user_info
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户id,由系统生成 */
    @Excel(name = "用户id,由系统生成")
    private String uuid;

    /** 用户钱包地址 */
    @Excel(name = "用户钱包地址")
    private String userAddress;

    /** v4/v6 暂不保存 */
    @Excel(name = "v4/v6 暂不保存")
    private String ip;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String invitationCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }

    public void setUserAddress(String userAddress) 
    {
        this.userAddress = userAddress;
    }

    public String getUserAddress() 
    {
        return userAddress;
    }

    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }

    public void setInvitationCode(String invitationCode) 
    {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() 
    {
        return invitationCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("userAddress", getUserAddress())
            .append("ip", getIp())
            .append("createTime", getCreateTime())
            .append("invitationCode", getInvitationCode())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
