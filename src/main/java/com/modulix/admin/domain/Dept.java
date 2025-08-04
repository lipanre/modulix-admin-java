package com.modulix.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;
import com.modulix.admin.vo.DeptVO;
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
 * (Dept)实体类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
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
