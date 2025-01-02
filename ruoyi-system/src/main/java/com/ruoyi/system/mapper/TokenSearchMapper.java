package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TokenSearch;

/**
 * 开盘池子信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-29
 */
public interface TokenSearchMapper 
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
     * 删除开盘池子信息
     * 
     * @param id 开盘池子信息主键
     * @return 结果
     */
    public int deleteTokenSearchById(String id);

    /**
     * 批量删除开盘池子信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTokenSearchByIds(String[] ids);

    /**
     * 根据token查询最大tvl的记录  获取最大池子信息
     */
    public TokenSearch getMaxTvlByToken(String token);
}
