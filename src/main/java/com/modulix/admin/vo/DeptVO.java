package com.modulix.admin.vo;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Dept;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * (Dept)实体类VO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Dept.class),
        @AutoMapper(target = DeptDTO.class),
        @AutoMapper(target = DeptQuery.class),
})
public class DeptVO extends Dept {

}

