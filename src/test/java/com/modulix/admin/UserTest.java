package com.modulix.admin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author lipanre
 */
@ExtendWith(SpringExtension.class)
public class UserTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void test_generate_password() {
        System.out.println(passwordEncoder.encode("modulix:admin123"));
    }

}
