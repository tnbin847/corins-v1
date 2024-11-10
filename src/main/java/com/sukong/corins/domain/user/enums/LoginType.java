package com.sukong.corins.domain.user.enums;

import com.sukong.corins.global.common.mybatis.CodeEnum;
import lombok.RequiredArgsConstructor;

/**
 * Created by 박 수 빈 on 24. 11. 9.
 */

@RequiredArgsConstructor
public enum LoginType implements CodeEnum {
    LOCAL ("LOCAL", "로컬"),
    SOCIAL ("OAUTH", "소셜");

    private final String code;
    private final String label;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
