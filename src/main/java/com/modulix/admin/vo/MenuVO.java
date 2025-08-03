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


/**
 * 菜单(Menu)实体类VO
 *
 * @author lipanre
 * @since 2025-07-28 22:51:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Menu.class),
        @AutoMapper(target = MenuDTO.class),
        @AutoMapper(target = MenuQuery.class),
})
public class MenuVO extends Menu {

}

