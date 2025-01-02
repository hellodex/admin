package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SubAdMapper;
import com.ruoyi.system.domain.SubAd;
import com.ruoyi.system.service.ISubAdService;
import com.ruoyi.common.core.text.Convert;

/**
 * 子广告Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Service
public class SubAdServiceImpl implements ISubAdService 
{
    @Autowired
    private SubAdMapper subAdMapper;

    /**
     * 查询子广告
     * 
     * @param id 子广告主键
     * @return 子广告
     */
    @Override
    public SubAd selectSubAdById(Long id)
    {
        return subAdMapper.selectSubAdById(id);
    }

    /**
     * 查询子广告列表
     * 
     * @param subAd 子广告
     * @return 子广告
     */
    @Override
    public List<SubAd> selectSubAdList(SubAd subAd)
    {
        return subAdMapper.selectSubAdList(subAd);
    }

    /**
     * 新增子广告
     * 
     * @param subAd 子广告
     * @return 结果
     */
    @Override
    public int insertSubAd(SubAd subAd)
    {
        return subAdMapper.insertSubAd(subAd);
    }

    /**
     * 修改子广告
     * 
     * @param subAd 子广告
     * @return 结果
     */
    @Override
    public int updateSubAd(SubAd subAd)
    {
        return subAdMapper.updateSubAd(subAd);
    }

    /**
     * 批量删除子广告
     * 
     * @param ids 需要删除的子广告主键
     * @return 结果
     */
    @Override
    public int deleteSubAdByIds(String ids)
    {
        return subAdMapper.deleteSubAdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子广告信息
     * 
     * @param id 子广告主键
     * @return 结果
     */
    @Override
    public int deleteSubAdById(Long id)
    {
        return subAdMapper.deleteSubAdById(id);
    }
}
