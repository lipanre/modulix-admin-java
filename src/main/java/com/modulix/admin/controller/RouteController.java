package com.modulix.admin.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.modulix.admin.service.RouterService;
import com.modulix.admin.vo.RouteVO;
import com.modulix.admin.vo.UserRouteVO;
import com.modulix.framework.web.aip.http.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
