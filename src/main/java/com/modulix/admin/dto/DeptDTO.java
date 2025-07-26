package com.modulix.admin.dto;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Dept;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.query.DeptQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * (Dept)实体类DTO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.id, BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Dept.class),
        @AutoMapper(target = DeptVO.class),
        @AutoMapper(target = DeptQuery.class),
})
public class DeptDTO extends Dept {

}

