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
import lombok.experimental.FieldNameConstants;


/**
 * 用户(User)实体类VO
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = User.class),
        @AutoMapper(target = UserDTO.class),
        @AutoMapper(target = UserQuery.class),
})
@FieldNameConstants
public class UserVO extends User {

}

