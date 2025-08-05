package com.modulix.admin.vo;

import com.modulix.admin.domain.Menu;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

import java.util.List;

/**
 * 菜单按钮VO
 *
 * @author lipanre
 */
@Data
@AutoMapper(target = Menu.class)
public class MenuButtonVO {

    /**
     * 菜单名
     */
    @AutoMapping(target = "label")
    private String menuName;

    /**
     * 按钮列表
     */
    private List<Menu.Button> buttons;

}
