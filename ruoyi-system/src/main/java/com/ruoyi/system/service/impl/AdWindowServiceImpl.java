package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AdWindowMapper;
import com.ruoyi.system.domain.AdWindow;
import com.ruoyi.system.service.IAdWindowService;
import com.ruoyi.common.core.text.Convert;

/**
 * 弹窗Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Service
public class AdWindowServiceImpl implements IAdWindowService 
{
    @Autowired
    private AdWindowMapper adWindowMapper;

    /**
     * 查询弹窗
     * 
     * @param id 弹窗主键
     * @return 弹窗
     */
    @Override
    public AdWindow selectAdWindowById(Long id)
    {
        return adWindowMapper.selectAdWindowById(id);
    }

    /**
     * 查询弹窗列表
     * 
     * @param adWindow 弹窗
     * @return 弹窗
     */
    @Override
    public List<AdWindow> selectAdWindowList(AdWindow adWindow)
    {
        return adWindowMapper.selectAdWindowList(adWindow);
    }

    /**
     * 新增弹窗
     * 
     * @param adWindow 弹窗
     * @return 结果
     */
    @Override
    public int insertAdWindow(AdWindow adWindow)
    {
        return adWindowMapper.insertAdWindow(adWindow);
    }

    /**
     * 修改弹窗
     * 
     * @param adWindow 弹窗
     * @return 结果
     */
    @Override
    public int updateAdWindow(AdWindow adWindow)
    {
        return adWindowMapper.updateAdWindow(adWindow);
    }

    /**
     * 批量删除弹窗
     * 
     * @param ids 需要删除的弹窗主键
     * @return 结果
     */
    @Override
    public int deleteAdWindowByIds(String ids)
    {
        return adWindowMapper.deleteAdWindowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除弹窗信息
     * 
     * @param id 弹窗主键
     * @return 结果
     */
    @Override
    public int deleteAdWindowById(Long id)
    {
        return adWindowMapper.deleteAdWindowById(id);
    }
}
