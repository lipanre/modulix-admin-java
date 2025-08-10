package com.modulix.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * 用户路由vo
 *
 * @author lipanre
 */
@Data
public class UserRouteVO {

    /**
     * 路由首页
     */
    private String home;

    /**
     * 路由列表
     */
    private List<RouteVO> routes;

}
