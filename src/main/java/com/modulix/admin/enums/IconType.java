package com.modulix.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 图标类型
 *
 * @author lipanre
 */
@Getter
@RequiredArgsConstructor
public enum IconType {

    ICONIFY("iconify"),

    LOCAL("local"),

    ;

    @EnumValue
    @JsonValue
    private final String code;

}
