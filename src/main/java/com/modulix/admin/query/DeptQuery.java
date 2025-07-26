package com.modulix.admin.query;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Dept;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Dept;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * (Dept)实体类Query
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Dept.class),
        @AutoMapper(target = DeptDTO.class),
        @AutoMapper(target = DeptVO.class),
})
public class DeptQuery extends Dept {

}

