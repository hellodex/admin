package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TokenMetaMapper;
import com.ruoyi.system.domain.TokenMeta;
import com.ruoyi.system.service.ITokenMetaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 代币基本信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-28
 */
@Service
public class TokenMetaServiceImpl implements ITokenMetaService 
{
    @Autowired
    private TokenMetaMapper tokenMetaMapper;

    /**
     * 查询代币基本信息
     * 
     * @param id 代币基本信息主键
     * @return 代币基本信息
     */
    @Override
    public TokenMeta selectTokenMetaById(Long id)
    {
        return tokenMetaMapper.selectTokenMetaById(id);
    }

    /**
     * 查询代币基本信息列表
     * 
     * @param tokenMeta 代币基本信息
     * @return 代币基本信息
     */
    @Override
    public List<TokenMeta> selectTokenMetaList(TokenMeta tokenMeta)
    {
        return tokenMetaMapper.selectTokenMetaList(tokenMeta);
    }

    /**
     * 新增代币基本信息
     * 
     * @param tokenMeta 代币基本信息
     * @return 结果
     */
    @Override
    public int insertTokenMeta(TokenMeta tokenMeta)
    {
        tokenMeta.setCreateTime(DateUtils.getNowDate());
        return tokenMetaMapper.insertTokenMeta(tokenMeta);
    }

    /**
     * 修改代币基本信息
     * 
     * @param tokenMeta 代币基本信息
     * @return 结果
     */
    @Override
    public int updateTokenMeta(TokenMeta tokenMeta)
    {
        return tokenMetaMapper.updateTokenMeta(tokenMeta);
    }

    /**
     * 批量删除代币基本信息
     * 
     * @param ids 需要删除的代币基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTokenMetaByIds(String ids)
    {
        return tokenMetaMapper.deleteTokenMetaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代币基本信息信息
     * 
     * @param id 代币基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTokenMetaById(Long id)
    {
        return tokenMetaMapper.deleteTokenMetaById(id);
    }

    @Override
    public TokenMeta getTokenMetaByAddressAndChainCode(String address, String chainCode) {
        if (address == null || chainCode == null) {
            return null;
        }
        TokenMeta tokenMeta = new TokenMeta();
        tokenMeta.setAddress(address);
        tokenMeta.setChainCode(chainCode);
        List<TokenMeta> tokenMetas = tokenMetaMapper.selectTokenMetaList(tokenMeta);
        if(!tokenMetas.isEmpty()){
            return tokenMetas.get(0);
        }
        return null;
    }
}
