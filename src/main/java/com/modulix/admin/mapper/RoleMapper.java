package com.modulix.admin.mapper;

import com.modulix.admin.domain.Role;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.vo.RoleVO;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.query.RoleQuery;

import java.util.List;

import com.modulix.framework.mybatis.plus.api.base.BaseMapper;


/**
 * 角色表(Role)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<RoleVO> list(RoleQuery query) {
        MPJLambdaWrapper<Role> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Role.class);
        wrapper.orderByDesc(Role::getCreateTime);
        return selectJoinList(RoleVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default RoleVO getDetail(Long id) {
        MPJLambdaWrapper<Role> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Role.class);
        wrapper.eq(Role::getId, id);
        return selectJoinOne(RoleVO.class, wrapper);
    }
}

