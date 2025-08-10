package com.modulix.admin.vo;

import com.modulix.admin.menu.MenuQueryParam;
import com.modulix.framework.common.core.util.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 路由VO
 *
 * @author lipanre
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RouteVO extends TreeNode<Long> {

    private Long id;

    private Long parentId;


    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 路由组件
     */
    private String component;

    /**
     * 路由属性描述
     */
    private Meta meta;

    @Data
    static class Meta {

        /**
         * 标题
         */
        private String title;

        /**
         * 用于国际化的展示文本，优先级高于title
         */
        private String i18nKey;

        /**
         * 路由顺序
         */
        private Integer order;

        /**
         * 缓存路由
         */
        private Boolean keepAlive;

        /**
         * 是否是常量路由
         */
        private Boolean constant;

        /**
         * iconify图标
         */
        private String icon;

        /**
         * 本地图标
         */
        private String localIcon;

        /**
         * 外链
         */
        private String href;

        /**
         * 是否在菜单中隐藏路由
         */
        private Boolean hideInMenu;

        /**
         * 当前路由对应的激活状态菜单
         */
        private String activeMenu;

        /**
         * 是否支持多页签Tab
         */
        private Boolean multiTab;

        /**
         * 固定在页签中的路由索引
         */
        private Integer fixedIndexInTab;

        /**
         * 查询参数
         */
        private List<MenuQueryParam> query;


    }

}
