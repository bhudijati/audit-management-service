package com.bjpu.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AuditManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditManagementServiceApplication.class, args);
    }
}
