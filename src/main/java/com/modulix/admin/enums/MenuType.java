package com.modulix.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 菜单类型
 *
 * @author lipanre
 */
@Getter
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
public enum MenuType {

    /**
     * 目录
     */
    DIR("dir"),

    /**
     * 菜单
     */
    MENU("menu"),

    ;

    @EnumValue
    @JsonValue
    private final String code;




}
