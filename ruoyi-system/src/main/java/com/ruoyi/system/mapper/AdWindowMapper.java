package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AdWindow;

/**
 * 弹窗Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public interface AdWindowMapper 
{
    /**
     * 查询弹窗
     * 
     * @param id 弹窗主键
     * @return 弹窗
     */
    public AdWindow selectAdWindowById(Long id);

    /**
     * 查询弹窗列表
     * 
     * @param adWindow 弹窗
     * @return 弹窗集合
     */
    public List<AdWindow> selectAdWindowList(AdWindow adWindow);

    /**
     * 新增弹窗
     * 
     * @param adWindow 弹窗
     * @return 结果
     */
    public int insertAdWindow(AdWindow adWindow);

    /**
     * 修改弹窗
     * 
     * @param adWindow 弹窗
     * @return 结果
     */
    public int updateAdWindow(AdWindow adWindow);

    /**
     * 删除弹窗
     * 
     * @param id 弹窗主键
     * @return 结果
     */
    public int deleteAdWindowById(Long id);

    /**
     * 批量删除弹窗
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdWindowByIds(String[] ids);
}
