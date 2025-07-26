package com.modulix.admin.query;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Login;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Login;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.dto.LoginDTO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 登录记录(Login)实体类Query
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Login.class),
        @AutoMapper(target = LoginDTO.class),
        @AutoMapper(target = LoginVO.class),
})
public class LoginQuery extends Login {

}

