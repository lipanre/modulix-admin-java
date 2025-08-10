package com.modulix.admin.vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

/**
 * 登录信息
 *
 * @author lipanre
 */
@Data
@AutoMapper(target = SaTokenInfo.class)
public class LoginInfo {

    /**
     * token 头名
     */
    @AutoMapping(target = "tokenName")
    private String header;

    /**
     * token
     */
    @AutoMapping(target = "tokenValue")
    private String token;

    /**
     * 过期时间
     */
    @AutoMapping(target = "tokenTimeout")
    private long expire;

    /**
     * 刷新token
     */
    private String refreshToken;

}
