package com.modulix.admin.service.impl;

import com.modulix.admin.domain.User;
import com.modulix.admin.service.UserService;
import com.modulix.framework.security.api.auth.AuthenticationService;
import com.modulix.framework.security.api.auth.AuthenticationServiceType;
import com.modulix.framework.security.api.auth.UserInfo;
import com.modulix.framework.security.api.auth.admin.AdminAccountAuthentication;
import io.github.linpeilie.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.function.Supplier;

/**
 * @author lipanre
 */
@Service(AuthenticationServiceType.ADMIN_ACCOUNT)
@RequiredArgsConstructor
public class AdminAuthService implements AuthenticationService<AdminAccountAuthentication> {

    private final UserService userService;

    private final Converter converter;


    @Override
    public <F> AdminAccountAuthentication loadAuthentication(Supplier<F> usernameSupplier) {
        User user = userService.getUserByUsername((String) usernameSupplier.get());
        return converter.convert(user, AdminAccountAuthentication.class);
    }

    @Override
    public AdminAccountAuthentication loadAuthenticationById(Long userId) {
        User user = userService.getById(userId);
        AdminAccountAuthentication authentication = converter.convert(user, AdminAccountAuthentication.class);
        authentication.setDataScopes(Collections.emptyList());
        return authentication;
    }

    @Override
    public UserInfo getUserInfo(Long userId) {
        User user = userService.getById(userId);
        UserInfo userInfo = converter.convert(user, UserInfo.class);
        userInfo.setRoles(Collections.emptyList());
        userInfo.setButtons(Collections.emptyList());
        return userInfo;
    }
}
