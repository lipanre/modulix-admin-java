package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Role;
import com.modulix.admin.vo.RoleVO;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.query.RoleQuery;

import java.util.List;

/**
 * 角色表(Role)表服务接口
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(RoleDTO dto);

    /**
     * 删除
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    Boolean removeBatch(List<Long> ids);

    /**
     * 更新
     *
     * @param id  id
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    Boolean update(Long id, RoleDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<RoleVO> list(RoleQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    RoleVO detail(Long id);
}
