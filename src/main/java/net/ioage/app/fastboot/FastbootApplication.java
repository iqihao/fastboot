package net.ioage.app.fastboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@MapperScan({"net.ioage.app.fastboot.auth.mapper","net.ioage.app.fastboot.module.*.mapper"})
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class FastbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastbootApplication.class, args);
    }

}
