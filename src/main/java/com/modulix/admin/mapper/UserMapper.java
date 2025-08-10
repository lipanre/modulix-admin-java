package com.modulix.admin.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.domain.Dept;
import com.modulix.admin.domain.User;
import com.modulix.admin.query.UserQuery;
import com.modulix.admin.vo.UserInfo;
import com.modulix.admin.vo.UserVO;
import com.modulix.framework.mybatis.plus.api.base.BaseMapper;
import com.modulix.framework.mybatis.plus.api.enums.DataScope;

import java.util.List;


/**
 * 用户(User)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
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
        wrapper.selectAssociation(Dept.class, UserVO::getDeptName, map -> map.result(Dept::getName));
        wrapper.leftJoin(Dept.class, Dept::getId, User::getDeptId);
        wrapper.likeIfExists(User::getUsername, query.getUsername());
        wrapper.likeIfExists(User::getNickname, query.getNickname());
        wrapper.eqIfExists(User::getDeptId, query.getDeptId());
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
        MPJLambdaWrapper<User> wrapper = MPJWrappers.lambdaJoin(User.class);
        wrapper.eq(User::getId, id);
        return selectJoinOne(UserVO.class, wrapper);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    default User getByUsername(String username) {
        MPJLambdaWrapper<User> wrapper = JoinWrappers.lambda(User.class);
        wrapper.selectAll();
        wrapper.eq(User::getUsername, username);
        return selectJoinOne(wrapper);
    }

    /**
     * 查询指定用户的数据权限列表
     *
     * @param userId 用户id
     * @return 数据权限
     */
    @InterceptorIgnore(others = "page@true")
    List<DataScope> listDataScopes(Long userId);

    /**
     * 获取制定用户的用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    UserInfo getUserInfo(long userId);
}

