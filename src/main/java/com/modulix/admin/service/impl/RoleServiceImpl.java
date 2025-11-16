package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Role;
import com.modulix.admin.mapper.RoleMapper;
import com.modulix.admin.service.RoleService;
import com.modulix.framework.security.api.common.RoleCode;
import com.modulix.framework.web.api.exception.BizException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.RoleVO;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.query.RoleQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 角色表(Role)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public Boolean create(RoleDTO dto) {
        if (CollectionUtils.containsAny(List.of(RoleCode.ADMIN_ROLE_CODE, RoleCode.SUPER_ADMIN_ROLE_CODE), dto.getCode())) {
            throw new BizException("禁止创建系统内置角色编码角色");
        }
        Role domain = converter.convert(dto, Role.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, RoleDTO dto) {
        if (CollectionUtils.containsAny(List.of(RoleCode.ADMIN_ROLE_CODE, RoleCode.SUPER_ADMIN_ROLE_CODE), dto.getCode())) {
            throw new BizException("禁止更新系统内置角色");
        }
        Role domain = converter.convert(dto, Role.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<RoleVO> list(RoleQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public RoleVO detail(Long id) {
        return baseMapper.getDetail(id);
    }
}
