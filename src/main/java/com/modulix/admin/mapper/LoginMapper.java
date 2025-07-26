package com.modulix.admin.mapper;

import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.domain.Login;
import com.modulix.admin.query.LoginQuery;
import com.modulix.admin.vo.LoginVO;
import com.modulix.framework.mybatis.plus.api.base.BaseMapper;

import java.util.List;


/**
 * 登录记录(Login)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
public interface LoginMapper extends BaseMapper<Login> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<LoginVO> list(LoginQuery query) {
        MPJLambdaWrapper<Login> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Login.class);
        wrapper.orderByDesc(Login::getCreateTime);
        return selectJoinList(LoginVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default LoginVO getDetail(Long id) {
        MPJLambdaWrapper<Login> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Login.class);
        wrapper.eq(Login::getId, id);
        return selectJoinOne(LoginVO.class, wrapper);
    }

    /**
     * 获取用户id
     *
     * @param refreshToken refreshToken
     * @return 获取用户id
     */
    default String getUserId(String refreshToken) {
        MPJLambdaWrapper<Login> wrapper = JoinWrappers.lambda();
        wrapper.eq(Login::getRefreshToken, refreshToken);
        return selectColumn(wrapper, Login::getUserInfo);
    }

    /**
     * 删除指定用户的
     *
     * @param userId   用户id
     * @param clientId
     * @return 删除结果
     */
    Boolean removeLoginInfo(Long userId, String clientId);
}

