package com.modulix.admin;

import io.github.linpeilie.annotations.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lipanre
 */
@SpringBootApplication
@MapperConfig(mapperPackage = "com.modulix.admin.mapstruct")
public class ModulixAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModulixAdminApplication.class, args);
    }
}
