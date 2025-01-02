package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 弹窗对象 ad_window
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public class AdWindow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String logo;

    /** 跳转地址 */
    @Excel(name = "跳转地址")
    private String url;

    /** 官网 */
    @Excel(name = "官网")
    private String website;

    /** telegram */
    @Excel(name = "telegram")
    private String telegram;

    /** twitter */
    @Excel(name = "twitter")
    private String twitter;

    /** discord */
    @Excel(name = "discord")
    private String discord;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public String getWebsite() 
    {
        return website;
    }

    public void setTelegram(String telegram) 
    {
        this.telegram = telegram;
    }

    public String getTelegram() 
    {
        return telegram;
    }

    public void setTwitter(String twitter) 
    {
        this.twitter = twitter;
    }

    public String getTwitter() 
    {
        return twitter;
    }

    public void setDiscord(String discord) 
    {
        this.discord = discord;
    }

    public String getDiscord() 
    {
        return discord;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("logo", getLogo())
            .append("url", getUrl())
            .append("website", getWebsite())
            .append("telegram", getTelegram())
            .append("twitter", getTwitter())
            .append("discord", getDiscord())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("addTime", getAddTime())
            .toString();
    }
}
