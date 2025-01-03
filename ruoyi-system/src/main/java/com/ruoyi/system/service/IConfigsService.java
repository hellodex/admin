package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Configs;

/**
 * 公链配置Service接口
 * 
 * @author ruoyi
 * @date 2025-01-03
 */
public interface IConfigsService 
{
    /**
     * 查询公链配置
     * 
     * @param id 公链配置主键
     * @return 公链配置
     */
    public Configs selectConfigsById(String id);

    /**
     * 查询公链配置列表
     * 
     * @param configs 公链配置
     * @return 公链配置集合
     */
    public List<Configs> selectConfigsList(Configs configs);

    /**
     * 新增公链配置
     * 
     * @param configs 公链配置
     * @return 结果
     */
    public int insertConfigs(Configs configs);

    /**
     * 修改公链配置
     * 
     * @param configs 公链配置
     * @return 结果
     */
    public int updateConfigs(Configs configs);

    /**
     * 批量删除公链配置
     * 
     * @param ids 需要删除的公链配置主键集合
     * @return 结果
     */
    public int deleteConfigsByIds(String ids);

    /**
     * 删除公链配置信息
     * 
     * @param id 公链配置主键
     * @return 结果
     */
    public int deleteConfigsById(String id);
}
