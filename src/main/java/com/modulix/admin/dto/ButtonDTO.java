package com.modulix.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.Button;
import com.modulix.admin.query.ButtonQuery;
import com.modulix.admin.vo.ButtonVO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * (Button)实体类DTO
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Button.class),
        @AutoMapper(target = ButtonVO.class),
        @AutoMapper(target = ButtonQuery.class),
})
public class ButtonDTO extends Button {

}

