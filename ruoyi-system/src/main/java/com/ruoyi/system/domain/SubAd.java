package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 子广告对象 sub_ad
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public class SubAd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关联adid */
    @Excel(name = "关联adid")
    private Long adId;

    /** 公链 */
    @Excel(name = "公链")
    private String chainId;

    /** 广告标题 */
    @Excel(name = "广告标题")
    private String title;

    /** logo */
    @Excel(name = "logo")
    private String logo;

    /** 跳转 */
    @Excel(name = "跳转")
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

    /** 0显示,1:隐藏 */
    @Excel(name = "0显示,1:隐藏")
    private String isShow;

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

    public void setAdId(Long adId) 
    {
        this.adId = adId;
    }

    public Long getAdId() 
    {
        return adId;
    }

    public void setChainId(String chainId) 
    {
        this.chainId = chainId;
    }

    public String getChainId() 
    {
        return chainId;
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

    public void setIsShow(String isShow) 
    {
        this.isShow = isShow;
    }

    public String getIsShow() 
    {
        return isShow;
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
            .append("adId", getAdId())
            .append("chainId", getChainId())
            .append("title", getTitle())
            .append("logo", getLogo())
            .append("url", getUrl())
            .append("website", getWebsite())
            .append("telegram", getTelegram())
            .append("twitter", getTwitter())
            .append("discord", getDiscord())
            .append("isShow", getIsShow())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("addTime", getAddTime())
            .toString();
    }
}
