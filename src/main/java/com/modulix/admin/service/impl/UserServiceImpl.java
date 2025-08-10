package com.modulix.admin.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.modulix.admin.domain.Role;
import com.modulix.admin.domain.User;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.mapper.UserMapper;
import com.modulix.admin.query.UserQuery;
import com.modulix.admin.service.UserService;
import com.modulix.admin.vo.UserInfo;
import com.modulix.admin.vo.UserVO;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import com.modulix.framework.mybatis.plus.api.enums.DataScope;
import com.modulix.framework.security.api.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 用户(User)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService, SecurityContext {


    public static final String DEFAULT_HOME = "home";

    @Override
    public Boolean create(UserDTO dto) {
        User domain = converter.convert(dto, User.class);
        if (StringUtils.isNotEmpty(dto.getPassword())) {
            domain.setPassword(BCrypt.hashpw(dto.getPassword()));
        }
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, UserDTO dto) {
        User domain = converter.convert(dto, User.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<UserVO> list(UserQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public UserVO detail(Long id) {
        return baseMapper.getDetail(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return baseMapper.getByUsername(username);
    }

    @Override
    public UserInfo getUserInfo(long userId) {
        return baseMapper.getUserInfo(userId);
    }

    @Override
    public String getUserHome(long userId) {
        Role role = baseMapper.getUserHome(userId);
        if (Objects.isNull(role)) {
            // 默认首页
            return DEFAULT_HOME;
        }
        return role.getHome();
    }

    @Override
    public List<DataScope> getDataScopes(Long userId) {
        return baseMapper.listDataScopes(userId);
    }
}
