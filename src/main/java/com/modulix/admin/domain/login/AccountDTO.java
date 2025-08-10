package com.modulix.admin.domain.login;

import lombok.Data;

/**
 * 用户名登录dto
 *
 * @author lipanre
 */
@Data
public class AccountDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
