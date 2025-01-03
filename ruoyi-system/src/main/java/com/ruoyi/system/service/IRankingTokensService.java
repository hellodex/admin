package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RankingTokens;
import com.ruoyi.system.domain.vo.RankingTokensVo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public interface IRankingTokensService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public RankingTokens selectRankingTokensById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rankingTokensVo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RankingTokensVo> selectRankingTokensList(RankingTokensVo rankingTokensVo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param rankingTokens 【请填写功能名称】
     * @return 结果
     */
    public int insertRankingTokens(RankingTokens rankingTokens);

    /**
     * 修改【请填写功能名称】
     * 
     * @param rankingTokens 【请填写功能名称】
     * @return 结果
     */
    public int updateRankingTokens(RankingTokens rankingTokens);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRankingTokensByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRankingTokensById(Long id);

    /**
     * 根据rankingId查询最大优先级
     */

    int getMaxPriorityByRankingId(Long rankingId);
}
