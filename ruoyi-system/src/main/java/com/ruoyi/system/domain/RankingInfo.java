package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 榜单信息对象 ranking_info
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public class RankingInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 榜单名称 */
    @Excel(name = "榜单名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long logo;

    /** 在页面中显示的位置 0: 首页 1:市场 */
    @Excel(name = "在页面中显示的位置 0: 首页 1:市场")
    private Long location;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

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

    public void setLogo(Long logo) 
    {
        this.logo = logo;
    }

    public Long getLogo() 
    {
        return logo;
    }

    public void setLocation(Long location) 
    {
        this.location = location;
    }

    public Long getLocation() 
    {
        return location;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("logo", getLogo())
            .append("location", getLocation())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
