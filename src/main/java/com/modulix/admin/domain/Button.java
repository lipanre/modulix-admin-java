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
import com.modulix.admin.vo.ButtonVO;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.admin.query.ButtonQuery;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.modulix.framework.validation.common.ValidateGroup;
import lombok.experimental.FieldNameConstants;


/**
 * (Button)实体类
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_button")
@AutoMappers({
        @AutoMapper(target = ButtonVO.class),
        @AutoMapper(target = ButtonDTO.class),
        @AutoMapper(target = ButtonQuery.class),
})
@FieldNameConstants
public class Button extends BaseDomain {


    /**
     * 按钮名称
     */
    @Length(max = 30, message = "按钮名称(name)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String name;

    /**
     * 按钮编码
     */
    @Length(max = 30, message = "按钮编码(code)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String code;

    /**
     * 所属菜单id
     */
    private Long menuId;
}
