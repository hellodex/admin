package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代币基本信息对象 token_meta
 * 
 * @author ruoyi
 * @date 2024-12-28
 */
public class TokenMeta extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** token全名 */
    @Excel(name = "token全名")
    private String name;

    /** 简称 */
    @Excel(name = "简称")
    private String symbol;

    /** 合约地址 */
    @Excel(name = "合约地址")
    private String address;

    /** 图片 */
    @Excel(name = "图片")
    private String logo;

    /** 代币类型 */
    @Excel(name = "代币类型")
    private Long tokenType;

    /** 链标识 */
    @Excel(name = "链标识")
    private String chainCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long hot;

    /** 精度 */
    @Excel(name = "精度")
    private Long decimals;

    /** 协议名 */
    @Excel(name = "协议名")
    private String protocol;

    /** 协议地址 */
    @Excel(name = "协议地址")
    private String protocolUrl;

    /** 白皮书地址 */
    @Excel(name = "白皮书地址")
    private String whitePaper;

    /** 网站 */
    @Excel(name = "网站")
    private String website;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String discord;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String twitter;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String telegram;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setSymbol(String symbol) 
    {
        this.symbol = symbol;
    }

    public String getSymbol() 
    {
        return symbol;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }

    public void setTokenType(Long tokenType) 
    {
        this.tokenType = tokenType;
    }

    public Long getTokenType() 
    {
        return tokenType;
    }

    public void setChainCode(String chainCode) 
    {
        this.chainCode = chainCode;
    }

    public String getChainCode() 
    {
        return chainCode;
    }

    public void setHot(Long hot) 
    {
        this.hot = hot;
    }

    public Long getHot() 
    {
        return hot;
    }

    public void setDecimals(Long decimals) 
    {
        this.decimals = decimals;
    }

    public Long getDecimals() 
    {
        return decimals;
    }

    public void setProtocol(String protocol) 
    {
        this.protocol = protocol;
    }

    public String getProtocol() 
    {
        return protocol;
    }

    public void setProtocolUrl(String protocolUrl) 
    {
        this.protocolUrl = protocolUrl;
    }

    public String getProtocolUrl() 
    {
        return protocolUrl;
    }

    public void setWhitePaper(String whitePaper) 
    {
        this.whitePaper = whitePaper;
    }

    public String getWhitePaper() 
    {
        return whitePaper;
    }

    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public String getWebsite() 
    {
        return website;
    }

    public void setDiscord(String discord) 
    {
        this.discord = discord;
    }

    public String getDiscord() 
    {
        return discord;
    }

    public void setTwitter(String twitter) 
    {
        this.twitter = twitter;
    }

    public String getTwitter() 
    {
        return twitter;
    }

    public void setTelegram(String telegram) 
    {
        this.telegram = telegram;
    }

    public String getTelegram() 
    {
        return telegram;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("symbol", getSymbol())
            .append("address", getAddress())
            .append("logo", getLogo())
            .append("tokenType", getTokenType())
            .append("chainCode", getChainCode())
            .append("hot", getHot())
            .append("decimals", getDecimals())
            .append("protocol", getProtocol())
            .append("protocolUrl", getProtocolUrl())
            .append("whitePaper", getWhitePaper())
            .append("website", getWebsite())
            .append("discord", getDiscord())
            .append("twitter", getTwitter())
            .append("telegram", getTelegram())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .toString();
    }
}
