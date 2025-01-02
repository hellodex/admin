package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RankingInfo;

/**
 * 榜单信息Service接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface IRankingInfoService 
{
    /**
     * 查询榜单信息
     * 
     * @param id 榜单信息主键
     * @return 榜单信息
     */
    public RankingInfo selectRankingInfoById(Long id);

    /**
     * 查询榜单信息列表
     * 
     * @param rankingInfo 榜单信息
     * @return 榜单信息集合
     */
    public List<RankingInfo> selectRankingInfoList(RankingInfo rankingInfo);

    /**
     * 新增榜单信息
     * 
     * @param rankingInfo 榜单信息
     * @return 结果
     */
    public int insertRankingInfo(RankingInfo rankingInfo);

    /**
     * 修改榜单信息
     * 
     * @param rankingInfo 榜单信息
     * @return 结果
     */
    public int updateRankingInfo(RankingInfo rankingInfo);

    /**
     * 批量删除榜单信息
     * 
     * @param ids 需要删除的榜单信息主键集合
     * @return 结果
     */
    public int deleteRankingInfoByIds(String ids);

    /**
     * 删除榜单信息信息
     * 
     * @param id 榜单信息主键
     * @return 结果
     */
    public int deleteRankingInfoById(Long id);
}
