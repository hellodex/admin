package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WithdrawalRecordMapper;
import com.ruoyi.system.domain.WithdrawalRecord;
import com.ruoyi.system.service.IWithdrawalRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 提现记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Service
public class WithdrawalRecordServiceImpl implements IWithdrawalRecordService 
{
    @Autowired
    private WithdrawalRecordMapper withdrawalRecordMapper;

    /**
     * 查询提现记录
     * 
     * @param id 提现记录主键
     * @return 提现记录
     */
    @Override
    public WithdrawalRecord selectWithdrawalRecordById(Long id)
    {
        return withdrawalRecordMapper.selectWithdrawalRecordById(id);
    }

    /**
     * 查询提现记录列表
     * 
     * @param withdrawalRecord 提现记录
     * @return 提现记录
     */
    @Override
    public List<WithdrawalRecord> selectWithdrawalRecordList(WithdrawalRecord withdrawalRecord)
    {
        return withdrawalRecordMapper.selectWithdrawalRecordList(withdrawalRecord);
    }

    /**
     * 新增提现记录
     * 
     * @param withdrawalRecord 提现记录
     * @return 结果
     */
    @Override
    public int insertWithdrawalRecord(WithdrawalRecord withdrawalRecord)
    {
        withdrawalRecord.setCreateTime(DateUtils.getNowDate());
        return withdrawalRecordMapper.insertWithdrawalRecord(withdrawalRecord);
    }

    /**
     * 修改提现记录
     * 
     * @param withdrawalRecord 提现记录
     * @return 结果
     */
    @Override
    public int updateWithdrawalRecord(WithdrawalRecord withdrawalRecord)
    {
        withdrawalRecord.setUpdateTime(DateUtils.getNowDate());
        return withdrawalRecordMapper.updateWithdrawalRecord(withdrawalRecord);
    }

    /**
     * 批量删除提现记录
     * 
     * @param ids 需要删除的提现记录主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalRecordByIds(String ids)
    {
        return withdrawalRecordMapper.deleteWithdrawalRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除提现记录信息
     * 
     * @param id 提现记录主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalRecordById(Long id)
    {
        return withdrawalRecordMapper.deleteWithdrawalRecordById(id);
    }
}
