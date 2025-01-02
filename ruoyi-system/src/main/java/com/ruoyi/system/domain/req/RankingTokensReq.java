package com.ruoyi.system.domain.req;

import java.io.Serializable;

/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2024/12/31
 */
public class RankingTokensReq implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;

    /** 榜单类型 */

    private Long rankingId;

    /** 池子id */
    private Long searchId;

    /** 链标识 */
    private String chainCode;

    /** 优先级 越大优先级越高 */
    private Long priority;

    /** 几个火 */
    private Long hot;

    /** 来源dex */
    private Long dex;

    /** 起始时间 */
    private String startTime;

    /** 截止时间 */
    private String endTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRankingId() {
        return rankingId;
    }

    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public Long getDex() {
        return dex;
    }

    public void setDex(Long dex) {
        this.dex = dex;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
