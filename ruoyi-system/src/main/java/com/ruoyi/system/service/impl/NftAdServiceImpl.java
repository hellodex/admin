package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NftAdMapper;
import com.ruoyi.system.domain.NftAd;
import com.ruoyi.system.service.INftAdService;
import com.ruoyi.common.core.text.Convert;

/**
 * nft轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Service
public class NftAdServiceImpl implements INftAdService 
{
    @Autowired
    private NftAdMapper nftAdMapper;

    /**
     * 查询nft轮播图
     * 
     * @param id nft轮播图主键
     * @return nft轮播图
     */
    @Override
    public NftAd selectNftAdById(Long id)
    {
        return nftAdMapper.selectNftAdById(id);
    }

    /**
     * 查询nft轮播图列表
     * 
     * @param nftAd nft轮播图
     * @return nft轮播图
     */
    @Override
    public List<NftAd> selectNftAdList(NftAd nftAd)
    {
        return nftAdMapper.selectNftAdList(nftAd);
    }

    /**
     * 新增nft轮播图
     * 
     * @param nftAd nft轮播图
     * @return 结果
     */
    @Override
    public int insertNftAd(NftAd nftAd)
    {
        return nftAdMapper.insertNftAd(nftAd);
    }

    /**
     * 修改nft轮播图
     * 
     * @param nftAd nft轮播图
     * @return 结果
     */
    @Override
    public int updateNftAd(NftAd nftAd)
    {
        return nftAdMapper.updateNftAd(nftAd);
    }

    /**
     * 批量删除nft轮播图
     * 
     * @param ids 需要删除的nft轮播图主键
     * @return 结果
     */
    @Override
    public int deleteNftAdByIds(String ids)
    {
        return nftAdMapper.deleteNftAdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除nft轮播图信息
     * 
     * @param id nft轮播图主键
     * @return 结果
     */
    @Override
    public int deleteNftAdById(Long id)
    {
        return nftAdMapper.deleteNftAdById(id);
    }
}
