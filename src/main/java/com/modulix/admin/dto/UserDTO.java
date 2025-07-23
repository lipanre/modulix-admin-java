package com.modulix.admin.dto;

import java.time.LocalDateTime;

import com.modulix.admin.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.User;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.query.UserQuery;
import lombok.experimental.FieldNameConstants;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 用户(User)实体类DTO
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.id, BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = User.class),
        @AutoMapper(target = UserVO.class),
        @AutoMapper(target = UserQuery.class),
})
@FieldNameConstants
public class UserDTO extends User {

}

