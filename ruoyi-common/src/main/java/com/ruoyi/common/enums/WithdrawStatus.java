package com.ruoyi.common.enums;

import com.ruoyi.common.core.domain.Kv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO 类作用描述
 *
 * @author sbl
 * @date 2025/1/1
 */
public enum WithdrawStatus {

    OK("200", "已发放"),
    PENDING_APPROVAL("201", "待审核"),
    PENDING_CHAIN("202", "待上链"),
    ABANDON("500", "放弃验证"),
    FAIL("501", "发送失败");

    private final String code;
    private final String info;

    WithdrawStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }

    public static List<Kv> getEnumObjList() {
        WithdrawStatus[] values = WithdrawStatus.values();
        List<Kv> result = new ArrayList<>();

        for (WithdrawStatus status : values) {
            result.add(new Kv(status.code, status.info)); // 假设 WithdrawStatus 有一个 getValue() 方法
        }

        return result;
    }


}
