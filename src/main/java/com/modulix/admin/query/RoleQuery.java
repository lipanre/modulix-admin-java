package com.modulix.admin.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.Role;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.vo.RoleVO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;


/**
 * 角色表(Role)实体类Query
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Role.class),
        @AutoMapper(target = RoleDTO.class),
        @AutoMapper(target = RoleVO.class),
})
@FieldNameConstants
public class RoleQuery extends Role {

}

