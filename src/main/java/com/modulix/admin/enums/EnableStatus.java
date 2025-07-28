package com.modulix.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 启用状态
 *
 * @author lipanre
 */
@Getter
@RequiredArgsConstructor
public enum EnableStatus {

    ENABLE("enable"),

    DISABLE("disable"),
    ;

    @EnumValue
    @JsonValue
    private final String code;
}
