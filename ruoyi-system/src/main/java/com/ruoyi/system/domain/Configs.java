package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公链配置对象 configs
 * 
 * @author ruoyi
 * @date 2025-01-03
 */
public class Configs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 公链名 */
    @Excel(name = "公链名")
    private String chain;

    /** 公链id */
    @Excel(name = "公链id")
    private Long chainId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chainCode;

    /** 主币名 */
    @Excel(name = "主币名")
    private String symbol;

    /** 主币在okxapi的地址 */
    @Excel(name = "主币在okxapi的地址")
    private String symbolAddress;

    /** 主网类型 */
    @Excel(name = "主网类型")
    private String network;

    /** 0:显示,1:隐藏 */
    @Excel(name = "0:显示,1:隐藏")
    private String isShow;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 链logo */
    @Excel(name = "链logo")
    private String logo;

    /** 主网币logo */
    @Excel(name = "主网币logo")
    private String tokenLogo;

    /** 主网地址 */
    @Excel(name = "主网地址")
    private String rpc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String wssRpc;

    /** 区块浏览器 */
    @Excel(name = "区块浏览器")
    private String browser;

    /** okx授权合约地址 */
    @Excel(name = "okx授权合约地址")
    private String approveAddress;

    /** 代理合约 */
    @Excel(name = "代理合约")
    private String proxy;

    /** 下单api */
    @Excel(name = "下单api")
    private String rpcProxy;

    /** 公链主网币地址 */
    @Excel(name = "公链主网币地址")
    private String address;

    /** 包装主网币地址 */
    @Excel(name = "包装主网币地址")
    private String wrapped;

    /** 主网币位数 */
    @Excel(name = "主网币位数")
    private String decimals;

    /** 默认交易gasprice费 */
    @Excel(name = "默认交易gasprice费")
    private String gas;

    /** 默认gaslimit费 */
    @Excel(name = "默认gaslimit费")
    private String gasLimit;

    /** 转账默认gaslimit */
    @Excel(name = "转账默认gaslimit")
    private String sendGasLimit;

    /** 转账默认gasprice */
    @Excel(name = "转账默认gasprice")
    private String sendGasPrice;

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

    public void setSymbol(String symbol) 
    {
        this.symbol = symbol;
    }

    public String getSymbol() 
    {
        return symbol;
    }

    public void setSymbolAddress(String symbolAddress) 
    {
        this.symbolAddress = symbolAddress;
    }

    public String getSymbolAddress() 
    {
        return symbolAddress;
    }

    public void setNetwork(String network) 
    {
        this.network = network;
    }

    public String getNetwork() 
    {
        return network;
    }

    public void setIsShow(String isShow) 
    {
        this.isShow = isShow;
    }

    public String getIsShow() 
    {
        return isShow;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }

    public void setTokenLogo(String tokenLogo) 
    {
        this.tokenLogo = tokenLogo;
    }

    public String getTokenLogo() 
    {
        return tokenLogo;
    }

    public void setRpc(String rpc) 
    {
        this.rpc = rpc;
    }

    public String getRpc() 
    {
        return rpc;
    }

    public void setWssRpc(String wssRpc) 
    {
        this.wssRpc = wssRpc;
    }

    public String getWssRpc() 
    {
        return wssRpc;
    }

    public void setBrowser(String browser) 
    {
        this.browser = browser;
    }

    public String getBrowser() 
    {
        return browser;
    }

    public void setApproveAddress(String approveAddress) 
    {
        this.approveAddress = approveAddress;
    }

    public String getApproveAddress() 
    {
        return approveAddress;
    }

    public void setProxy(String proxy) 
    {
        this.proxy = proxy;
    }

    public String getProxy() 
    {
        return proxy;
    }

    public void setRpcProxy(String rpcProxy) 
    {
        this.rpcProxy = rpcProxy;
    }

    public String getRpcProxy() 
    {
        return rpcProxy;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setWrapped(String wrapped) 
    {
        this.wrapped = wrapped;
    }

    public String getWrapped() 
    {
        return wrapped;
    }

    public void setDecimals(String decimals) 
    {
        this.decimals = decimals;
    }

    public String getDecimals() 
    {
        return decimals;
    }

    public void setGas(String gas) 
    {
        this.gas = gas;
    }

    public String getGas() 
    {
        return gas;
    }

    public void setGasLimit(String gasLimit) 
    {
        this.gasLimit = gasLimit;
    }

    public String getGasLimit() 
    {
        return gasLimit;
    }

    public void setSendGasLimit(String sendGasLimit) 
    {
        this.sendGasLimit = sendGasLimit;
    }

    public String getSendGasLimit() 
    {
        return sendGasLimit;
    }

    public void setSendGasPrice(String sendGasPrice) 
    {
        this.sendGasPrice = sendGasPrice;
    }

    public String getSendGasPrice() 
    {
        return sendGasPrice;
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
            .append("symbol", getSymbol())
            .append("symbolAddress", getSymbolAddress())
            .append("network", getNetwork())
            .append("isShow", getIsShow())
            .append("sort", getSort())
            .append("logo", getLogo())
            .append("tokenLogo", getTokenLogo())
            .append("rpc", getRpc())
            .append("wssRpc", getWssRpc())
            .append("browser", getBrowser())
            .append("approveAddress", getApproveAddress())
            .append("proxy", getProxy())
            .append("rpcProxy", getRpcProxy())
            .append("address", getAddress())
            .append("wrapped", getWrapped())
            .append("decimals", getDecimals())
            .append("gas", getGas())
            .append("gasLimit", getGasLimit())
            .append("sendGasLimit", getSendGasLimit())
            .append("sendGasPrice", getSendGasPrice())
            .append("addTime", getAddTime())
            .toString();
    }
}
