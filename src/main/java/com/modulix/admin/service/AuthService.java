package com.modulix.admin.service;

import com.modulix.admin.dto.AuthDTO;
import com.modulix.admin.vo.LoginInfo;
import com.modulix.admin.vo.UserInfo;

/**
 * 登录记录(Login)表服务接口
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
public interface AuthService {

    /**
     * 用户名密码登录
     *
     * @param dto 账户dto
     * @return 登录信息
     */
    LoginInfo login(AuthDTO dto);

    /**
     * 刷新token
     *
     * @return 刷新之后的登录信息
     */
    LoginInfo refresh(LoginInfo loginInfo);

    /**
     * 获取当前登录用户的用户信息
     *
     * @return 用户信息
     */
    UserInfo getUserInfo(long userId);
}
