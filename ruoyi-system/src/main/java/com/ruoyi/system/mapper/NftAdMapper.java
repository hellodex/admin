package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.NftAd;

/**
 * nft轮播图Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public interface NftAdMapper 
{
    /**
     * 查询nft轮播图
     * 
     * @param id nft轮播图主键
     * @return nft轮播图
     */
    public NftAd selectNftAdById(Long id);

    /**
     * 查询nft轮播图列表
     * 
     * @param nftAd nft轮播图
     * @return nft轮播图集合
     */
    public List<NftAd> selectNftAdList(NftAd nftAd);

    /**
     * 新增nft轮播图
     * 
     * @param nftAd nft轮播图
     * @return 结果
     */
    public int insertNftAd(NftAd nftAd);

    /**
     * 修改nft轮播图
     * 
     * @param nftAd nft轮播图
     * @return 结果
     */
    public int updateNftAd(NftAd nftAd);

    /**
     * 删除nft轮播图
     * 
     * @param id nft轮播图主键
     * @return 结果
     */
    public int deleteNftAdById(Long id);

    /**
     * 批量删除nft轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNftAdByIds(String[] ids);
}
