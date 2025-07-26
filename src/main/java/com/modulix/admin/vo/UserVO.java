package com.modulix.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.User;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.query.UserQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户(User)实体类VO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, User.Fields.password})
@AutoMappers({
        @AutoMapper(target = User.class),
        @AutoMapper(target = UserDTO.class),
        @AutoMapper(target = UserQuery.class),
})
public class UserVO extends User {

}

