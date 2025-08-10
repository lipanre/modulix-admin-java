package com.modulix.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.enums.EnableStatus;
import com.modulix.admin.query.UserQuery;
import com.modulix.admin.vo.UserVO;
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

import java.util.List;


/**
 * 用户(User)实体类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@AutoMappers({
        @AutoMapper(target = UserVO.class),
        @AutoMapper(target = UserDTO.class),
        @AutoMapper(target = UserQuery.class),
})
@FieldNameConstants
public class User extends BaseDomain {


    /**
     * 用户名
     */
    @Length(max = 50, message = "用户名(username)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "用户名(username)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String username;

    /**
     * 密码
     */
    @Length(max = 80, message = "密码(password)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String password;

    /**
     * 昵称
     */
    @Length(max = 30, message = "昵称(nickname)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "昵称(nickname)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String nickname;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 手机号码
     */
    @Length(max = 11, message = "手机号码(phone)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String phone;

    /**
     * 性别
     */
    private String gender;

    /**
     * 邮箱
     */
    @Length(max = 50, message = "邮箱(email)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String email;

    /**
     * 启用状态
     */
    @NotNull(message = "启用状态(enable)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private EnableStatus enable;

    /**
     * 首页
     */
    private Long homeRoleId;

    /**
     * 角色id列表
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Long> roleIds;
}
