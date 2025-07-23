package com.modulix.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;


/**
 * 菜单(Menu)实体类VO
 *
 * @author lipanre
 * @since 2025-07-24 01:29:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Menu.class),
        @AutoMapper(target = MenuDTO.class),
        @AutoMapper(target = MenuQuery.class),
})
@FieldNameConstants
public class MenuVO extends Menu {

}

