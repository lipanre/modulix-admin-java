package com.modulix.admin.vo;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 菜单(Menu)实体类VO
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.createTime, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted})
@AutoMappers({
        @AutoMapper(target = Menu.class),
        @AutoMapper(target = MenuDTO.class),
        @AutoMapper(target = MenuQuery.class),
})
public class MenuVO extends Menu {

}

