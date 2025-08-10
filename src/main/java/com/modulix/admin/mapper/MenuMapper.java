package com.modulix.admin.mapper;

import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.domain.Button;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.query.MenuQuery;
import com.modulix.admin.vo.MenuButtonVO;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.vo.RouteVO;
import com.modulix.framework.mybatis.plus.api.base.BaseMapper;

import java.util.List;


/**
 * 菜单(Menu)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-28 22:51:56
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<MenuVO> list(MenuQuery query) {
        MPJLambdaWrapper<Menu> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Menu.class);
        wrapper.orderByAsc(Menu::getSort);
        wrapper.orderByDesc(Menu::getCreateTime);
        return selectJoinList(MenuVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default MenuVO getDetail(Long id) {
        MPJLambdaWrapper<Menu> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Menu.class);
        wrapper.selectCollection(Button.class, MenuVO::getButtons);
        wrapper.leftJoin(Button.class, Button::getMenuId, Menu::getId);
        wrapper.eq(Menu::getId, id);
        return selectJoinOne(MenuVO.class, wrapper);
    }

    /**
     * 页面列表
     *
     * @return 页面列表
     */
    default List<String> listPage() {
        MPJLambdaWrapper<Menu> wrapper = JoinWrappers.lambda(Menu.class);
        wrapper.select(Menu::getRouteName);
        return selectColumnList(wrapper, Menu::getRouteName);
    }

    /**
     * 查询符合条件的菜单按钮列表
     *
     * @param query 查询条件
     * @return 菜单按钮列表
     */
    List<MenuButtonVO> listMenuButton(MenuQuery query);

    /**
     * 获取指定用户的路由列表
     *
     * @param userId 用户id
     * @return 路由列表
     */
    List<RouteVO> listUserRoute(long userId);

    /**
     * 获取常量路由
     *
     * @return 常量路由
     */
    List<RouteVO> listConstantRoute();
}

