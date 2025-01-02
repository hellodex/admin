package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 开盘池子信息对象 token_search
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public class TokenSearch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 公链 */
    @Excel(name = "公链")
    private String chain;

    /** 链号 */
    @Excel(name = "链号")
    private Long chainId;

    /** 链标志 */
    @Excel(name = "链标志")
    private String chainCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String baseAddress;

    /** 小数点位数 */
    @Excel(name = "小数点位数")
    private Long baseDecimals;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pairAddress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String baseToken;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String quoteToken;

    /** 价值币地址 */
    @Excel(name = "价值币地址")
    private String quoteAddress;

    /** 价值币小数位数 */
    @Excel(name = "价值币小数位数")
    private Long quoteDecimals;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal tvl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String details;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChain(String chain)
    {
        this.chain = chain;
    }

    public String getChain() 
    {
        return chain;
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

    public void setBaseAddress(String baseAddress) 
    {
        this.baseAddress = baseAddress;
    }

    public String getBaseAddress() 
    {
        return baseAddress;
    }

    public void setBaseDecimals(Long baseDecimals) 
    {
        this.baseDecimals = baseDecimals;
    }

    public Long getBaseDecimals() 
    {
        return baseDecimals;
    }

    public void setPairAddress(String pairAddress) 
    {
        this.pairAddress = pairAddress;
    }

    public String getPairAddress() 
    {
        return pairAddress;
    }

    public void setBaseToken(String baseToken) 
    {
        this.baseToken = baseToken;
    }

    public String getBaseToken() 
    {
        return baseToken;
    }

    public void setQuoteToken(String quoteToken) 
    {
        this.quoteToken = quoteToken;
    }

    public String getQuoteToken() 
    {
        return quoteToken;
    }

    public void setQuoteAddress(String quoteAddress) 
    {
        this.quoteAddress = quoteAddress;
    }

    public String getQuoteAddress() 
    {
        return quoteAddress;
    }

    public void setQuoteDecimals(Long quoteDecimals) 
    {
        this.quoteDecimals = quoteDecimals;
    }

    public Long getQuoteDecimals() 
    {
        return quoteDecimals;
    }

    public void setTvl(BigDecimal tvl) 
    {
        this.tvl = tvl;
    }

    public BigDecimal getTvl() 
    {
        return tvl;
    }

    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
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
            .append("chain", getChain())
            .append("chainId", getChainId())
            .append("chainCode", getChainCode())
            .append("baseAddress", getBaseAddress())
            .append("baseDecimals", getBaseDecimals())
            .append("pairAddress", getPairAddress())
            .append("baseToken", getBaseToken())
            .append("quoteToken", getQuoteToken())
            .append("quoteAddress", getQuoteAddress())
            .append("quoteDecimals", getQuoteDecimals())
            .append("tvl", getTvl())
            .append("details", getDetails())
            .append("addTime", getAddTime())
            .toString();
    }
}
