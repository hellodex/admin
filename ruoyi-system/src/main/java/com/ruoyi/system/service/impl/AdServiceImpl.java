package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AdMapper;
import com.ruoyi.system.domain.Ad;
import com.ruoyi.system.service.IAdService;
import com.ruoyi.common.core.text.Convert;

/**
 * 广告Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Service
public class AdServiceImpl implements IAdService 
{
    @Autowired
    private AdMapper adMapper;

    /**
     * 查询广告
     * 
     * @param id 广告主键
     * @return 广告
     */
    @Override
    public Ad selectAdById(String id)
    {
        return adMapper.selectAdById(id);
    }

    /**
     * 查询广告列表
     * 
     * @param ad 广告
     * @return 广告
     */
    @Override
    public List<Ad> selectAdList(Ad ad)
    {
        return adMapper.selectAdList(ad);
    }

    /**
     * 新增广告
     * 
     * @param ad 广告
     * @return 结果
     */
    @Override
    public int insertAd(Ad ad)
    {
        return adMapper.insertAd(ad);
    }

    /**
     * 修改广告
     * 
     * @param ad 广告
     * @return 结果
     */
    @Override
    public int updateAd(Ad ad)
    {
        return adMapper.updateAd(ad);
    }

    /**
     * 批量删除广告
     * 
     * @param ids 需要删除的广告主键
     * @return 结果
     */
    @Override
    public int deleteAdByIds(String ids)
    {
        return adMapper.deleteAdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除广告信息
     * 
     * @param id 广告主键
     * @return 结果
     */
    @Override
    public int deleteAdById(String id)
    {
        return adMapper.deleteAdById(id);
    }
}
