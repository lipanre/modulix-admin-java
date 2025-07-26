package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Login;
import com.modulix.admin.mapper.LoginMapper;
import com.modulix.admin.service.LoginService;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.dto.LoginDTO;
import com.modulix.admin.query.LoginQuery;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 登录记录(Login)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, Login> implements LoginService, com.modulix.framework.security.api.LoginService {


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
    public void recordLoginInfo(String userId, String refreshToken, Duration refreshExpiration, String clientId) {
        Login login = new Login();
        login.setUserInfo(userId);
        login.setRefreshToken(refreshToken);
        login.setExpireTime(LocalDateTime.now().plus(refreshExpiration));
        login.setClientId(clientId);
        save(login);
    }

    @Override
    public String getUserId(String refreshToken) {
        return baseMapper.getUserId(refreshToken);
    }

    @Override
    public Boolean removeLoginInfo(Long userId, String clientId) {
        return baseMapper.removeLoginInfo(userId, clientId);
    }
}
