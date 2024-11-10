package com.sukong.corins.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Created by 박 수 빈 on 24. 11. 8.
 */

@RequiredArgsConstructor
@Getter
public enum StatusTypeFormats {
    YES (1, "Y", true),
    NO (0, "N", false);

    private final int number;       // 정수형의 상태값
    private final String symbol;    // 문자열 타입의 상태값
    private final boolean bool;     // 논리형의 상태값

    /**
     * 전달 받은 정수형의 값을 알맞은 논리형의 상태값을 변환 및 반환한다.
     */
    public boolean toBoolean(int value) {
        return Arrays.stream(values())
                .filter(statusTypeFormat -> statusTypeFormat.getNumber() == value)
                .findFirst()
                .map(StatusTypeFormats::isBool)
                .orElseThrow(() -> new IllegalArgumentException("cannot convert '" + value + "' to boolean type."));
    }
}