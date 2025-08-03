package com.modulix.admin.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    DIR,

    /**
     * 菜单
     */
    MENU,

    ;




}
