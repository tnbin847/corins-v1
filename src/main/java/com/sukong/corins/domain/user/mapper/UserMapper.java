package com.sukong.corins.domain.user.mapper;

import com.sukong.corins.domain.user.dto.SignUpRequest;
import com.sukong.corins.domain.user.dto.UserRoleRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 박 수 빈 on 24. 11. 8.
 */

@Mapper
public interface UserMapper {
    /**
     * 전달받은 아이디와 같은 아이디를 사용하고 있는 사용자의 존재여부를 확인한다.
     */
    boolean existsUserById(String id);

    /**
     * 전달받은 이메일과 같은 이메일을 사용하고 있는 사용자의 존재여부를 확인한다.
     */
    boolean existsUserByEmail(String email);

    /**
     * 회원가입 정보를 저장한다.
     */
    int insertUser(SignUpRequest signUpRequest);

    /**
     * 가입된 계정의 권한 정보를 등록한다.
     */
    void insertUserRole(UserRoleRequest userRoleRequest);
}
