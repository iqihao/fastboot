package net.ioage.app.fastboot;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"net.ioage.app.fastboot.auth.mapper","net.ioage.app.fastboot.module.*.mapper"})
public class FastbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastbootApplication.class, args);
    }

}
