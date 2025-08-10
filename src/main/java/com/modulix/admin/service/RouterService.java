package com.modulix.admin.service;

import com.modulix.admin.vo.RouteVO;
import com.modulix.admin.vo.UserRouteVO;

import java.util.List;

/**
 * route service
 *
 * @author lipanre
 */
public interface RouterService {

    /**
     * 获取指定用户的路由列表
     *
     * @param userId 用户id
     * @return 路由列表
     */
    UserRouteVO getUserRoute(long userId);

    /**
     * 获取常量路由
     *
     * @return 常量路由
     */
    List<RouteVO> listConstantRoute();
}
