package com.modulix.admin.query;

import java.time.LocalDateTime;

import com.modulix.admin.domain.Menu;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.framework.mybatis.plus.api.base.BaseDomain;


/**
 * 菜单(Menu)实体类Query
 *
 * @author lipanre
 * @since 2025-07-28 22:51:57
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

