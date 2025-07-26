package com.modulix.admin.query;

import java.time.LocalDateTime;

import com.modulix.admin.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.User;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.dto.UserDTO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 用户(User)实体类Query
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = User.class),
        @AutoMapper(target = UserDTO.class),
        @AutoMapper(target = UserVO.class),
})
public class UserQuery extends User {

}

