package com.sukong.corins.global.common.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by 박 수 빈 on 24. 11. 9.
 */

@MappedTypes(CodeEnum.class)
public class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> type;    // 타입 핸들러에서 처리할 Enum 클래스
    private final E[] constants;    // Enum 클래스 내에 정의된 상수들로 이루어진 배열

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("type argument cannot be null.");
        }
        this.type = type;
        this.constants = type.getEnumConstants();
        if (!type.isInterface() && this.constants == null) {
            throw new IllegalArgumentException("'" + type.getSimpleName() + "' does not represent an enum typ.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull() ? null : toCodeEnum(cs.getString(columnIndex));
    }

    /**
     * Enum 클래스 내의 상수값들 중 인자로 전달받은 코드값과 일치하는 상수값이 존재할 경우, 해당 Enum 클래스를 반환한다.
     *
     * @param dbCode    데이터베이스로부터 가져온 코드값
     * @return          Enum 클래스
     */
    private E toCodeEnum(String dbCode) {
        return Arrays.stream(constants)
                .filter(e -> e.getCode().equals(dbCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("cannot convert to '" + dbCode + "' to '" + type.getSimpleName() + "'."));
    }
}