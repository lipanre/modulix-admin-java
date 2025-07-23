package com.modulix.admin.domain;

import java.time.LocalDateTime;

import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.modulix.framework.validation.common.ValidateGroup;
import lombok.experimental.FieldNameConstants;


/**
 * (Dept)实体类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept")
@AutoMappers({
        @AutoMapper(target = DeptVO.class),
        @AutoMapper(target = DeptDTO.class),
        @AutoMapper(target = DeptQuery.class),
})
@FieldNameConstants
public class Dept extends BaseDomain {


    /**
     * 部门名称
     */
    @Length(max = 50, message = "部门名称(name)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "部门名称(name)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String name;

    /**
     * 上级部门id
     */
    @NotNull(message = "上级部门id(parentId)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private Long parentId;

    /**
     * 排序
     */
    @NotNull(message = "排序(sort)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private Integer sort;

    /**
     * 负责人
     */
    @Length(max = 50, message = "负责人(chargePerson)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String chargePerson;

    /**
     * 联系电话
     */
    @Length(max = 11, message = "联系电话(phone)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String phone;

    /**
     * 邮箱
     */
    @Length(max = 50, message = "邮箱(email)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String email;
}
