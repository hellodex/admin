package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WithdrawalRecord;

/**
 * 提现记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public interface WithdrawalRecordMapper 
{
    /**
     * 查询提现记录
     * 
     * @param id 提现记录主键
     * @return 提现记录
     */
    public WithdrawalRecord selectWithdrawalRecordById(Long id);

    /**
     * 查询提现记录列表
     * 
     * @param withdrawalRecord 提现记录
     * @return 提现记录集合
     */
    public List<WithdrawalRecord> selectWithdrawalRecordList(WithdrawalRecord withdrawalRecord);

    /**
     * 新增提现记录
     * 
     * @param withdrawalRecord 提现记录
     * @return 结果
     */
    public int insertWithdrawalRecord(WithdrawalRecord withdrawalRecord);

    /**
     * 修改提现记录
     * 
     * @param withdrawalRecord 提现记录
     * @return 结果
     */
    public int updateWithdrawalRecord(WithdrawalRecord withdrawalRecord);

    /**
     * 删除提现记录
     * 
     * @param id 提现记录主键
     * @return 结果
     */
    public int deleteWithdrawalRecordById(Long id);

    /**
     * 批量删除提现记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWithdrawalRecordByIds(String[] ids);
}
