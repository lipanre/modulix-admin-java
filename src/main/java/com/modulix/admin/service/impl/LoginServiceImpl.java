package com.modulix.admin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.temp.SaTempUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.digest.BCrypt;
import com.modulix.admin.domain.Login;
import com.modulix.admin.domain.User;
import com.modulix.admin.domain.login.AccountDTO;
import com.modulix.admin.dto.LoginDTO;
import com.modulix.admin.mapper.LoginMapper;
import com.modulix.admin.query.LoginQuery;
import com.modulix.admin.service.LoginService;
import com.modulix.admin.service.UserService;
import com.modulix.admin.vo.LoginInfo;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.vo.UserInfo;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import com.modulix.framework.web.aip.exception.BizException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 登录记录(Login)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, Login> implements LoginService {

    private final UserService userService;

    @Value("${sa-token.refresh-token.timeout:2592000}")
    private long refreshTokenExpire;


    @Override
    public Boolean create(LoginDTO dto) {
        Login domain = converter.convert(dto, Login.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, LoginDTO dto) {
        Login domain = converter.convert(dto, Login.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<LoginVO> list(LoginQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public LoginVO detail(Long id) {
        return baseMapper.getDetail(id);
    }

    @Override
    public LoginInfo login(AccountDTO dto) {
        User user = userService.getUserByUsername(dto.getUsername());
        if (Objects.isNull(user)) {
            throw new BizException("用户不存在");
        }
        if (!BCrypt.checkpw(dto.getPassword(), user.getPassword())) {
            throw new BizException("用户名或密码错误");
        }
        StpUtil.login(user.getId());
        LoginInfo loginInfo = converter.convert(StpUtil.getTokenInfo(), LoginInfo.class);
        loginInfo.setRefreshToken(SaTempUtil.createToken(user.getId(), refreshTokenExpire));
        return loginInfo;
    }

    @Override
    public LoginInfo refresh(LoginInfo loginInfo) {
        Assert.notEmpty(loginInfo.getRefreshToken(), "refreshToken不能为空");
        Long userId = SaTempUtil.parseToken(loginInfo.getRefreshToken(), Long.class);
        loginInfo.setToken(StpUtil.createLoginSession(userId));
        return loginInfo;
    }

    @Override
    public UserInfo getUserInfo(long userId) {
        return userService.getUserInfo(userId);
    }
}
