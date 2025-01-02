package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TokenSearch;

/**
 * 开盘池子信息Service接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface ITokenSearchService 
{
    /**
     * 查询开盘池子信息
     * 
     * @param id 开盘池子信息主键
     * @return 开盘池子信息
     */
    public TokenSearch selectTokenSearchById(String id);

    /**
     * 查询开盘池子信息列表
     * 
     * @param tokenSearch 开盘池子信息
     * @return 开盘池子信息集合
     */
    public List<TokenSearch> selectTokenSearchList(TokenSearch tokenSearch);

    /**
     * 新增开盘池子信息
     * 
     * @param tokenSearch 开盘池子信息
     * @return 结果
     */
    public int insertTokenSearch(TokenSearch tokenSearch);

    /**
     * 修改开盘池子信息
     * 
     * @param tokenSearch 开盘池子信息
     * @return 结果
     */
    public int updateTokenSearch(TokenSearch tokenSearch);

    /**
     * 批量删除开盘池子信息
     * 
     * @param ids 需要删除的开盘池子信息主键集合
     * @return 结果
     */
    public int deleteTokenSearchByIds(String ids);

    /**
     * 删除开盘池子信息信息
     * 
     * @param id 开盘池子信息主键
     * @return 结果
     */
    public int deleteTokenSearchById(String id);


    /**
     * 获取最大tvl
     * @param token
     */
    public TokenSearch  getMaxTvlByToken(String token);

}
