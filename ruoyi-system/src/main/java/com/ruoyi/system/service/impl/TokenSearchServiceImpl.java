package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TokenSearchMapper;
import com.ruoyi.system.domain.TokenSearch;
import com.ruoyi.system.service.ITokenSearchService;
import com.ruoyi.common.core.text.Convert;

/**
 * 开盘池子信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
@Service
public class TokenSearchServiceImpl implements ITokenSearchService 
{
    @Autowired
    private TokenSearchMapper tokenSearchMapper;

    /**
     * 查询开盘池子信息
     * 
     * @param id 开盘池子信息主键
     * @return 开盘池子信息
     */
    @Override
    public TokenSearch selectTokenSearchById(String id)
    {
        return tokenSearchMapper.selectTokenSearchById(id);
    }

    /**
     * 查询开盘池子信息列表
     * 
     * @param tokenSearch 开盘池子信息
     * @return 开盘池子信息
     */
    @Override
    public List<TokenSearch> selectTokenSearchList(TokenSearch tokenSearch)
    {
        return tokenSearchMapper.selectTokenSearchList(tokenSearch);
    }

    /**
     * 新增开盘池子信息
     * 
     * @param tokenSearch 开盘池子信息
     * @return 结果
     */
    @Override
    public int insertTokenSearch(TokenSearch tokenSearch)
    {
        return tokenSearchMapper.insertTokenSearch(tokenSearch);
    }

    /**
     * 修改开盘池子信息
     * 
     * @param tokenSearch 开盘池子信息
     * @return 结果
     */
    @Override
    public int updateTokenSearch(TokenSearch tokenSearch)
    {
        return tokenSearchMapper.updateTokenSearch(tokenSearch);
    }

    /**
     * 批量删除开盘池子信息
     * 
     * @param ids 需要删除的开盘池子信息主键
     * @return 结果
     */
    @Override
    public int deleteTokenSearchByIds(String ids)
    {
        return tokenSearchMapper.deleteTokenSearchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除开盘池子信息信息
     * 
     * @param id 开盘池子信息主键
     * @return 结果
     */
    @Override
    public int deleteTokenSearchById(String id)
    {
        return tokenSearchMapper.deleteTokenSearchById(id);
    }

    @Override
    public TokenSearch getMaxTvlByToken(String token) {
        return tokenSearchMapper.getMaxTvlByToken(token);
    }
}
