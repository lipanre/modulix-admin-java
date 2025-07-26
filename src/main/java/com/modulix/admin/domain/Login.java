package com.modulix.admin.domain;

import java.time.LocalDateTime;

import com.modulix.framework.mybatis.plus.api.base.BaseDomain;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.dto.LoginDTO;
import com.modulix.admin.query.LoginQuery;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.modulix.framework.validation.common.ValidateGroup;
import lombok.experimental.FieldNameConstants;


/**
 * 登录记录(Login)实体类
 *
 * @author lipanre
 * @since 2025-07-26 14:16:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_login")
@AutoMappers({
        @AutoMapper(target = LoginVO.class),
        @AutoMapper(target = LoginDTO.class),
        @AutoMapper(target = LoginQuery.class),
})
@FieldNameConstants
public class Login extends BaseDomain {


    /**
     * 用户信息：用户id
     */
    @Length(max = 30, message = "用户信息：用户id(userInfo)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String userInfo;

    /**
     * refresh token
     */
    @Length(max = 50, message = "refresh token(refreshToken)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String refreshToken;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 客户端id
     */
    @Length(max = 25, message = "客户端id(clientId)的长度不能超过{max}个字符", groups = {ValidateGroup.Insert.class, ValidateGroup.Update.class})
    private String clientId;
}
