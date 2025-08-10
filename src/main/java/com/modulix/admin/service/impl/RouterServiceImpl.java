package com.modulix.admin.service.impl;

import com.modulix.admin.mapper.MenuMapper;
import com.modulix.admin.service.RouterService;
import com.modulix.admin.service.UserService;
import com.modulix.admin.vo.RouteVO;
import com.modulix.admin.vo.UserRouteVO;
import com.modulix.framework.common.core.util.TreeUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路由serviceImpl
 *
 * @author lipanre
 */
@Slf4j
@Service
public class RouterServiceImpl implements RouterService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private UserService userService;



    @Override
    public UserRouteVO getUserRoute(long userId) {
        UserRouteVO userRouteVO = new UserRouteVO();
        userRouteVO.setRoutes(TreeUtil.buildTree(menuMapper.listUserRoute(userId)));
        userRouteVO.setHome(userService.getUserHome(userId));
        return userRouteVO;
    }

    @Override
    public List<RouteVO> listConstantRoute() {
        return menuMapper.listConstantRoute();
    }
}
