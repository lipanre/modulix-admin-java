package com.modulix.admin.service.impl;

import com.modulix.framework.security.api.auth.AuthenticationService;
import com.modulix.framework.security.api.auth.admin.AdminAccountAuthentication;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author lipanre
 */
@Service
public class UserService implements AuthenticationService<AdminAccountAuthentication> {
    @Override
    public <F> AdminAccountAuthentication loadAuthentication(Supplier<F> fieldSupplier) {
        return null;
    }

    @Override
    public AdminAccountAuthentication loadAuthenticationById(Long userId) {
        return null;
    }
}
