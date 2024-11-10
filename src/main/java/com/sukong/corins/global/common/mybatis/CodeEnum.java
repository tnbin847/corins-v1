package com.sukong.corins.global.common.mybatis;

/**
 * Created by 박 수 빈 on 24. 11. 9.
 */

public interface CodeEnum {
    /**
     * 데이터베이스 저장 및 데이터베이스로부터 가져온 코드를 Enum으로 변환하기 위해 문자열 타입의 코드값을 반환한다.
     */
    String getCode();

    /**
     * 뷰에 출력할 코드의 이름을 반환한다.
     */
    String getLabel();
}
