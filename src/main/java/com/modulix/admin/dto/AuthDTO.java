package com.modulix.admin.dto;

import lombok.Data;

/**
 * 认证dto
 *
 * @author lipanre
 */
@Data
public class AuthDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
