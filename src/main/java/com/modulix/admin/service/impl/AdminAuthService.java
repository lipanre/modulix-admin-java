package com.modulix.admin.service.impl;

import com.modulix.admin.domain.User;
import com.modulix.admin.service.UserService;
import com.modulix.framework.security.api.auth.AuthenticationService;
import com.modulix.framework.security.api.auth.admin.AdminAccountAuthentication;
import io.github.linpeilie.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author lipanre
 */
@Service
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
        return converter.convert(user, AdminAccountAuthentication.class);
    }
}
