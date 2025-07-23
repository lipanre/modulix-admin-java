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
import com.modulix.admin.vo.DictVO;
import com.modulix.admin.dto.DictDTO;
import com.modulix.admin.query.DictQuery;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.modulix.framework.validation.common.ValidateGroup;
import lombok.experimental.FieldNameConstants;


/**
 * 字典(Dict)实体类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict")
@AutoMappers({
        @AutoMapper(target = DictVO.class),
        @AutoMapper(target = DictDTO.class),
        @AutoMapper(target = DictQuery.class),
})
@FieldNameConstants
public class Dict extends BaseDomain {


    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 字典键
     */
    @Length(max = 30, message = "字典键(code)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "字典键(code)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String code;

    /**
     * 字典名
     */
    @Length(max = 30, message = "字典名(name)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    @NotEmpty(message = "字典名(name)不能为空", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String name;

    /**
     * 字典描述
     */
    @Length(max = 200, message = "字典描述(description)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String description;
}
