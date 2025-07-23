package com.modulix.admin.mapper;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.query.MenuQuery;
import com.modulix.admin.vo.MenuVO;
import com.modulix.framework.mybatis.plus.api.base.BaseMapper;

import java.util.List;


/**
 * 菜单(Menu)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
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
        wrapper.eq(Menu::getId, id);
        return selectJoinOne(MenuVO.class, wrapper);
    }
}

