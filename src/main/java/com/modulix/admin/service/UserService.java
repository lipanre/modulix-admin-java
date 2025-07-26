package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.User;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.query.UserQuery;

import java.util.List;

/**
 * 用户(User)表服务接口
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
public interface UserService extends BaseService<User> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(UserDTO dto);

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
    Boolean update(Long id, UserDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<UserVO> list(UserQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    UserVO detail(Long id);

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);
}
