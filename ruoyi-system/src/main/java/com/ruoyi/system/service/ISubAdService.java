package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SubAd;

/**
 * 子广告Service接口
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public interface ISubAdService 
{
    /**
     * 查询子广告
     * 
     * @param id 子广告主键
     * @return 子广告
     */
    public SubAd selectSubAdById(Long id);

    /**
     * 查询子广告列表
     * 
     * @param subAd 子广告
     * @return 子广告集合
     */
    public List<SubAd> selectSubAdList(SubAd subAd);

    /**
     * 新增子广告
     * 
     * @param subAd 子广告
     * @return 结果
     */
    public int insertSubAd(SubAd subAd);

    /**
     * 修改子广告
     * 
     * @param subAd 子广告
     * @return 结果
     */
    public int updateSubAd(SubAd subAd);

    /**
     * 批量删除子广告
     * 
     * @param ids 需要删除的子广告主键集合
     * @return 结果
     */
    public int deleteSubAdByIds(String ids);

    /**
     * 删除子广告信息
     * 
     * @param id 子广告主键
     * @return 结果
     */
    public int deleteSubAdById(Long id);
}