package com.modulix.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.query.RoleQuery;
import com.modulix.admin.vo.RoleVO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import com.modulix.framework.validation.common.ValidateGroup;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.hibernate.validator.constraints.Length;


/**
 * 角色表(Role)实体类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@AutoMappers({
        @AutoMapper(target = RoleVO.class),
        @AutoMapper(target = RoleDTO.class),
        @AutoMapper(target = RoleQuery.class),
})
@FieldNameConstants
public class Role extends BaseDomain {


    /**
     * 启用状态
     */
    @NotNull(message = "启用状态(enable)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private Boolean enable;

    /**
     * 角色名称
     */
    @Length(max = 50, message = "角色名称(name)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "角色名称(name)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String name;

    /**
     * 角色编码
     */
    @Length(max = 50, message = "角色编码(code)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "角色编码(code)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String code;

    /**
     * 角色描述
     */
    @Length(max = 200, message = "角色描述(description)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "角色描述(description)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String description;

    /**
     * 数据权限
     */
    @Length(max = 20, message = "数据权限(dataScope)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String dataScope;

    /**
     * 首页路径
     */
    @Length(max = 50, message = "首页路径(home)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String home;
}
