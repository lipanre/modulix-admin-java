package com.modulix.admin.vo;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Role;
import com.modulix.admin.dto.RoleDTO;
import com.modulix.admin.query.RoleQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 角色表(Role)实体类VO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Role.class),
        @AutoMapper(target = RoleDTO.class),
        @AutoMapper(target = RoleQuery.class),
})
public class RoleVO extends Role {

}

