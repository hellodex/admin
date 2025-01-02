package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RankingInfoMapper;
import com.ruoyi.system.domain.RankingInfo;
import com.ruoyi.system.service.IRankingInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 榜单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Service
public class RankingInfoServiceImpl implements IRankingInfoService 
{
    @Autowired
    private RankingInfoMapper rankingInfoMapper;

    /**
     * 查询榜单信息
     * 
     * @param id 榜单信息主键
     * @return 榜单信息
     */
    @Override
    public RankingInfo selectRankingInfoById(Long id)
    {
        return rankingInfoMapper.selectRankingInfoById(id);
    }

    /**
     * 查询榜单信息列表
     * 
     * @param rankingInfo 榜单信息
     * @return 榜单信息
     */
    @Override
    public List<RankingInfo> selectRankingInfoList(RankingInfo rankingInfo)
    {
        return rankingInfoMapper.selectRankingInfoList(rankingInfo);
    }

    /**
     * 新增榜单信息
     * 
     * @param rankingInfo 榜单信息
     * @return 结果
     */
    @Override
    public int insertRankingInfo(RankingInfo rankingInfo)
    {
        rankingInfo.setCreateTime(DateUtils.getNowDate());
        return rankingInfoMapper.insertRankingInfo(rankingInfo);
    }

    /**
     * 修改榜单信息
     * 
     * @param rankingInfo 榜单信息
     * @return 结果
     */
    @Override
    public int updateRankingInfo(RankingInfo rankingInfo)
    {
        rankingInfo.setUpdateTime(DateUtils.getNowDate());
        return rankingInfoMapper.updateRankingInfo(rankingInfo);
    }

    /**
     * 批量删除榜单信息
     * 
     * @param ids 需要删除的榜单信息主键
     * @return 结果
     */
    @Override
    public int deleteRankingInfoByIds(String ids)
    {
        return rankingInfoMapper.deleteRankingInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除榜单信息信息
     * 
     * @param id 榜单信息主键
     * @return 结果
     */
    @Override
    public int deleteRankingInfoById(Long id)
    {
        return rankingInfoMapper.deleteRankingInfoById(id);
    }
}
