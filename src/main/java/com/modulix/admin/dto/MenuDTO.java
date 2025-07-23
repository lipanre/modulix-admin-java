package com.modulix.admin.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.modulix.admin.domain.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.query.MenuQuery;
import lombok.experimental.FieldNameConstants;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 菜单(Menu)实体类DTO
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.id, BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Menu.class),
        @AutoMapper(target = MenuVO.class),
        @AutoMapper(target = MenuQuery.class),
})
@FieldNameConstants
public class MenuDTO extends Menu {

}

