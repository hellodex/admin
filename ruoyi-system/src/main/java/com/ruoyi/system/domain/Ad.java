package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告对象 ad
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public class Ad extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 公链 */
    @Excel(name = "公链")
    private Long chainId;

    /** 链标志 */
    @Excel(name = "链标志")
    private String chainCode;

    /** 钱包类型 */
    @Excel(name = "钱包类型")
    private Long chainType;

    /** 0:普通浏览器打开，1：dapp打开,2：系统浏览器 */
    @Excel(name = "0:普通浏览器打开，1：dapp打开,2：系统浏览器")
    private String openType;

    /** 广告标题 */
    @Excel(name = "广告标题")
    private String title;

    /** logo */
    @Excel(name = "logo")
    private String logo;

    /** 跳转 */
    @Excel(name = "跳转")
    private String url;

    /** 0:广告，1:活动，2:推广，100:网页使用 */
    @Excel(name = "0:广告，1:活动，2:推广，100:网页使用")
    private String adType;

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

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public void setChainId(Long chainId) 
    {
        this.chainId = chainId;
    }

    public Long getChainId() 
    {
        return chainId;
    }

    public void setChainCode(String chainCode) 
    {
        this.chainCode = chainCode;
    }

    public String getChainCode() 
    {
        return chainCode;
    }

    public void setChainType(Long chainType) 
    {
        this.chainType = chainType;
    }

    public Long getChainType() 
    {
        return chainType;
    }

    public void setOpenType(String openType) 
    {
        this.openType = openType;
    }

    public String getOpenType() 
    {
        return openType;
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

    public void setAdType(String adType) 
    {
        this.adType = adType;
    }

    public String getAdType() 
    {
        return adType;
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
            .append("sort", getSort())
            .append("chainId", getChainId())
            .append("chainCode", getChainCode())
            .append("chainType", getChainType())
            .append("openType", getOpenType())
            .append("title", getTitle())
            .append("logo", getLogo())
            .append("url", getUrl())
            .append("adType", getAdType())
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
