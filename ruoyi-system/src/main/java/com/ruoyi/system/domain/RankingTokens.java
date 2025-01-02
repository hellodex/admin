package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ranking_tokens
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public class RankingTokens extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 榜单类型 */
    @Excel(name = "榜单类型")
    private Long rankingId;

    /** 代币对详情id */
    @Excel(name = "代币对详情id")
    private Long infoId;

    /** 池子id */
    @Excel(name = "池子id")
    private Long searchId;

    /** 链标识 */
    @Excel(name = "链标识")
    private String chainCode;

    /** 优先级 越大优先级越高 */
    @Excel(name = "优先级 越大优先级越高")
    private Long priority;

    /** 几个火 */
    @Excel(name = "几个火")
    private Long hot;

    /** 来源dex */
    @Excel(name = "来源dex")
    private Long dex;

    /** 起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "起始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRankingId(Long rankingId) 
    {
        this.rankingId = rankingId;
    }

    public Long getRankingId() 
    {
        return rankingId;
    }

    public void setInfoId(Long infoId) 
    {
        this.infoId = infoId;
    }

    public Long getInfoId() 
    {
        return infoId;
    }

    public void setSearchId(Long searchId) 
    {
        this.searchId = searchId;
    }

    public Long getSearchId() 
    {
        return searchId;
    }

    public void setChainCode(String chainCode) 
    {
        this.chainCode = chainCode;
    }

    public String getChainCode() 
    {
        return chainCode;
    }

    public void setPriority(Long priority) 
    {
        this.priority = priority;
    }

    public Long getPriority() 
    {
        return priority;
    }

    public void setHot(Long hot) 
    {
        this.hot = hot;
    }

    public Long getHot() 
    {
        return hot;
    }

    public void setDex(Long dex) 
    {
        this.dex = dex;
    }

    public Long getDex() 
    {
        return dex;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rankingId", getRankingId())
            .append("infoId", getInfoId())
            .append("searchId", getSearchId())
            .append("chainCode", getChainCode())
            .append("priority", getPriority())
            .append("hot", getHot())
            .append("dex", getDex())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
