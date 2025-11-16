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

    /**
     * 判断指定用户是否绑定了指定的路由
     *
     * @param userId 用户id
     * @param path   路由路径
     * @return 是否存在
     */
    Boolean isRouterExists(long userId, String path);
}
