package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.vo.RankingTokensVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RankingTokensMapper;
import com.ruoyi.system.domain.RankingTokens;
import com.ruoyi.system.service.IRankingTokensService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Service
public class RankingTokensServiceImpl implements IRankingTokensService 
{
    @Autowired
    private RankingTokensMapper rankingTokensMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public RankingTokens selectRankingTokensById(Long id)
    {
        return rankingTokensMapper.selectRankingTokensById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rankingTokens 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RankingTokensVo> selectRankingTokensList(RankingTokensVo rankingTokens)
    {
        return rankingTokensMapper.selectRankingTokensList(rankingTokens);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param rankingTokens 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRankingTokens(RankingTokens rankingTokens)
    {
        rankingTokens.setCreateTime(DateUtils.getNowDate());
        return rankingTokensMapper.insertRankingTokens(rankingTokens);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param rankingTokens 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRankingTokens(RankingTokens rankingTokens)
    {
        return rankingTokensMapper.updateRankingTokens(rankingTokens);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRankingTokensByIds(String ids)
    {
        return rankingTokensMapper.deleteRankingTokensByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRankingTokensById(Long id)
    {
        return rankingTokensMapper.deleteRankingTokensById(id);
    }
}
