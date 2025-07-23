package com.modulix.admin.service.impl;

import com.modulix.admin.domain.User;
import com.modulix.admin.mapper.UserMapper;
import com.modulix.admin.service.UserService;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.query.UserQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户(User)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {


    @Override
    public Boolean create(UserDTO dto) {
        User domain = converter.convert(dto, User.class);
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
}
