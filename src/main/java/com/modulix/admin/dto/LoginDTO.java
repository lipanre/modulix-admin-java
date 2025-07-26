package com.modulix.admin.dto;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Login;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Login;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.query.LoginQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 登录记录(Login)实体类DTO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.id, BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Login.class),
        @AutoMapper(target = LoginVO.class),
        @AutoMapper(target = LoginQuery.class),
})
public class LoginDTO extends Login {

}

