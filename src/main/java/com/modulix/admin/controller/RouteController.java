package com.modulix.admin.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.modulix.admin.service.RouterService;
import com.modulix.admin.vo.RouteVO;
import com.modulix.admin.vo.UserRouteVO;
import com.modulix.framework.web.api.http.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 路由controller
 *
 * @author lipanre
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouterService routerService;

    /**
     * 获取当前登录用户的路由
     *
     * @return 当前登录用户的路由
     */
    @GetMapping("/user-route")
    public Response<UserRouteVO> getUserRoute() {
        return Response.success(routerService.getUserRoute(StpUtil.getLoginIdAsLong()));
    }

    /**
     * 获取常量路由
     *
     * @return 常量路由
     */
    @SaIgnore
    @GetMapping("/constant")
    public Response<List<RouteVO>> listConstantRoute() {
        return Response.success(routerService.listConstantRoute());
    }

    /**
     * 检查路由是否存在
     *
     * @param path 路由路径
     * @return 是否存在
     */
    @SaIgnore
    @GetMapping("/isRouteExist")
    public Response<Boolean> isRouterExists(@RequestParam String path) {
        return Response.success(routerService.isRouterExists(StpUtil.getLoginIdAsLong(), path));
    }
}
