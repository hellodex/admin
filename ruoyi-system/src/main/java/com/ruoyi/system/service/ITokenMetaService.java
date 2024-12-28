package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TokenMeta;

/**
 * 代币基本信息Service接口
 * 
 * @author ruoyi
 * @date 2024-12-28
 */
public interface ITokenMetaService 
{
    /**
     * 查询代币基本信息
     * 
     * @param id 代币基本信息主键
     * @return 代币基本信息
     */
    public TokenMeta selectTokenMetaById(Long id);

    /**
     * 查询代币基本信息列表
     * 
     * @param tokenMeta 代币基本信息
     * @return 代币基本信息集合
     */
    public List<TokenMeta> selectTokenMetaList(TokenMeta tokenMeta);

    /**
     * 新增代币基本信息
     * 
     * @param tokenMeta 代币基本信息
     * @return 结果
     */
    public int insertTokenMeta(TokenMeta tokenMeta);

    /**
     * 修改代币基本信息
     * 
     * @param tokenMeta 代币基本信息
     * @return 结果
     */
    public int updateTokenMeta(TokenMeta tokenMeta);

    /**
     * 批量删除代币基本信息
     * 
     * @param ids 需要删除的代币基本信息主键集合
     * @return 结果
     */
    public int deleteTokenMetaByIds(String ids);

    /**
     * 删除代币基本信息信息
     * 
     * @param id 代币基本信息主键
     * @return 结果
     */
    public int deleteTokenMetaById(Long id);
}
