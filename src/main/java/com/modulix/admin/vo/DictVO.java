package com.modulix.admin.vo;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Dict;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Dict;
import com.modulix.admin.dto.DictDTO;
import com.modulix.admin.query.DictQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 字典(Dict)实体类VO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Dict.class),
        @AutoMapper(target = DictDTO.class),
        @AutoMapper(target = DictQuery.class),
})
public class DictVO extends Dict {

}

