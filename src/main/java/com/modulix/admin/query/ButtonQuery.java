package com.modulix.admin.query;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Button;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Button;
import com.modulix.admin.vo.ButtonVO;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * (Button)实体类Query
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Button.class),
        @AutoMapper(target = ButtonDTO.class),
        @AutoMapper(target = ButtonVO.class),
})
public class ButtonQuery extends Button {

}

