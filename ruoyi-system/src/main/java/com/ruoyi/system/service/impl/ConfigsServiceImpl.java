package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ConfigsMapper;
import com.ruoyi.system.domain.Configs;
import com.ruoyi.system.service.IConfigsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公链配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-03
 */
@Service
public class ConfigsServiceImpl implements IConfigsService 
{
    @Autowired
    private ConfigsMapper configsMapper;

    /**
     * 查询公链配置
     * 
     * @param id 公链配置主键
     * @return 公链配置
     */
    @Override
    public Configs selectConfigsById(String id)
    {
        return configsMapper.selectConfigsById(id);
    }

    /**
     * 查询公链配置列表
     * 
     * @param configs 公链配置
     * @return 公链配置
     */
    @Override
    public List<Configs> selectConfigsList(Configs configs)
    {
        return configsMapper.selectConfigsList(configs);
    }

    /**
     * 新增公链配置
     * 
     * @param configs 公链配置
     * @return 结果
     */
    @Override
    public int insertConfigs(Configs configs)
    {
        return configsMapper.insertConfigs(configs);
    }

    /**
     * 修改公链配置
     * 
     * @param configs 公链配置
     * @return 结果
     */
    @Override
    public int updateConfigs(Configs configs)
    {
        return configsMapper.updateConfigs(configs);
    }

    /**
     * 批量删除公链配置
     * 
     * @param ids 需要删除的公链配置主键
     * @return 结果
     */
    @Override
    public int deleteConfigsByIds(String ids)
    {
        return configsMapper.deleteConfigsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公链配置信息
     * 
     * @param id 公链配置主键
     * @return 结果
     */
    @Override
    public int deleteConfigsById(String id)
    {
        return configsMapper.deleteConfigsById(id);
    }
}
