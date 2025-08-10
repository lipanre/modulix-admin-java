package com.modulix.admin.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.modulix.admin.domain.login.AccountDTO;
import com.modulix.admin.service.LoginService;
import com.modulix.admin.vo.LoginInfo;
import com.modulix.admin.vo.UserInfo;
import com.modulix.framework.web.aip.http.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 认证相关接口
 *
 * @author lipanre
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;

    /**
     * 用户名密码登录
     *
     * @param dto dto
     */
    @SaIgnore
    @PostMapping("/admin/login")
    public Response<LoginInfo> login(@RequestBody AccountDTO dto) {
        return Response.success(loginService.login(dto));
    }

    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public Response<String> logout() {
        StpUtil.logout();
        return Response.success("操作成功");
    }

    /**
     * 刷新token
     *
     * @param loginInfo refreshToken信息
     * @return 刷新后的token
     */
    @PostMapping("/refresh")
    public Response<LoginInfo> refresh(@RequestBody LoginInfo loginInfo) {
        return Response.success(loginService.refresh(loginInfo));
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/user-info")
    public Response<UserInfo> getUserInfo() {
        return Response.success(loginService.getUserInfo(StpUtil.getLoginIdAsLong()));
    }

}
