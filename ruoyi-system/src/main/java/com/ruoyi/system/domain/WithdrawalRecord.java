package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现记录对象 withdrawal_record
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public class WithdrawalRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userUuid;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private BigDecimal amount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tokenAddress;

    /** 提现目标地址 */
    @Excel(name = "提现目标地址")
    private String walletAddress;

    /** 提现链标识 */
    @Excel(name = "提现链标识")
    private String chainCode;

    /** 哈希 */
    @Excel(name = "哈希")
    private String tx;

    /** 状态 200:已发放 201:待审核 202:交易已发送等待上链 500:多次验证失败,放弃验证 501：发送失败 */
    @Excel(name = "状态 200:已发放 201:待审核 202:交易已发送等待上链 500:多次验证失败,放弃验证 501：发送失败")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserUuid(String userUuid) 
    {
        this.userUuid = userUuid;
    }

    public String getUserUuid() 
    {
        return userUuid;
    }

    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setTokenAddress(String tokenAddress) 
    {
        this.tokenAddress = tokenAddress;
    }

    public String getTokenAddress() 
    {
        return tokenAddress;
    }

    public void setWalletAddress(String walletAddress) 
    {
        this.walletAddress = walletAddress;
    }

    public String getWalletAddress() 
    {
        return walletAddress;
    }

    public void setChainCode(String chainCode) 
    {
        this.chainCode = chainCode;
    }

    public String getChainCode() 
    {
        return chainCode;
    }

    public void setTx(String tx) 
    {
        this.tx = tx;
    }

    public String getTx() 
    {
        return tx;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userUuid", getUserUuid())
            .append("amount", getAmount())
            .append("tokenAddress", getTokenAddress())
            .append("walletAddress", getWalletAddress())
            .append("chainCode", getChainCode())
            .append("tx", getTx())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
