package com.modulix.admin.mapper;

import com.modulix.admin.domain.User;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.query.UserQuery;

import java.util.List;

import com.modulix.framework.mybatis.plus.api.base.BaseMapper;


/**
 * 用户(User)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<UserVO> list(UserQuery query) {
        MPJLambdaWrapper<User> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(User.class);
        wrapper.orderByDesc(User::getCreateTime);
        return selectJoinList(UserVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default UserVO getDetail(Long id) {
        MPJLambdaWrapper<User> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(User.class);
        wrapper.eq(User::getId, id);
        return selectJoinOne(UserVO.class, wrapper);
    }
}

