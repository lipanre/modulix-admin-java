package com.modulix.admin.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.vo.MenuVO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 菜单(Menu)实体类Query
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({BaseDomain.Fields.creatorId, BaseDomain.Fields.modifierId, BaseDomain.Fields.deleted, BaseDomain.Fields.createTime, BaseDomain.Fields.modifyTime})
@AutoMappers({
        @AutoMapper(target = Menu.class),
        @AutoMapper(target = MenuDTO.class),
        @AutoMapper(target = MenuVO.class),
})
public class MenuQuery extends Menu {

}

