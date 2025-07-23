package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Role;
import com.modulix.admin.mapper.RoleMapper;
import com.modulix.admin.service.RoleService;
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
 * @since 2025-07-24 01:29:09
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public Boolean create(RoleDTO dto) {
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
