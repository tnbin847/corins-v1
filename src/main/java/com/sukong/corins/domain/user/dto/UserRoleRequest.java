package com.sukong.corins.domain.user.dto;

import com.sukong.corins.domain.user.enums.Role;
import com.sukong.corins.global.utils.StatusTypeFormats;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by 박 수 빈 on 24. 11. 8.
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserRoleRequest {
    private Long userId;

    private Role role;

    private String useYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public UserRoleRequest(Long userId, Role role, StatusTypeFormats statusTypeFormat) {
        this.userId = userId;
        this.role = role;
        this.useYn = statusTypeFormat.getSymbol();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}