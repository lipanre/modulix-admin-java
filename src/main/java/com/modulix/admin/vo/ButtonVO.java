package com.modulix.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.Button;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.admin.query.ButtonQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * (Button)实体类VO
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Button.class),
        @AutoMapper(target = ButtonDTO.class),
        @AutoMapper(target = ButtonQuery.class),
})
public class ButtonVO extends Button {

}

