package com.modulix.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import com.modulix.admin.vo.MenuVO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import com.modulix.framework.validation.common.ValidateGroup;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Length;

import java.util.Map;


/**
 * 菜单(Menu)实体类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
@AutoMappers({
        @AutoMapper(target = MenuVO.class),
        @AutoMapper(target = MenuDTO.class),
        @AutoMapper(target = MenuQuery.class),
})
@FieldNameConstants
public class Menu extends BaseDomain {


    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    @Length(max = 50, message = "菜单名称(name)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String name;

    /**
     * 路由路径
     */
    @Length(max = 50, message = "路由路径(path)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String path;

    @Length(max = 50, message = "${column.comment}(component)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String component;

    /**
     * 路由标题
     */
    @Length(max = 50, message = "路由标题(title)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String title;

    /**
     * 国际化key
     */
    @Length(max = 50, message = "国际化key(i18nKey)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String i18nKey;

    /**
     * 可访问角色
     */
    private Map roles;

    /**
     * 是否缓存
     */
    private Boolean keepAlive;

    /**
     * 是否是常量路由
     */
    private Boolean constant;

    /**
     * 菜单图标
     */
    @Length(max = 50, message = "菜单图标(icon)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String icon;

    /**
     * 图标大小
     */
    private Integer iconFontSize;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 外链链接
     */
    @Length(max = -1, message = "外链链接(href)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String href;

    /**
     * 是否隐藏菜单
     */
    private Boolean hideInMenu;

    /**
     * 激活菜单
     */
    @Length(max = 50, message = "激活菜单(activeMenu)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String activeMenu;

    /**
     * 是否可以开多tab
     */
    private Boolean multiTab;

    /**
     * 固定在tab中的位置
     */
    private Boolean fixedIndexInTab;

    /**
     * 查询参数
     */
    private Map query;
}
