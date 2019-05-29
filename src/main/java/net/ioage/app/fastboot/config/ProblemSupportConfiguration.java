package net.ioage.app.fastboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

/**
 * Created by qihao01 on 2019/5/29.
 */
@Configuration
public class ProblemSupportConfiguration {
    @Bean
    public ProblemModule problemModule() {
        //是否在响应中包含堆栈跟踪
        return new ProblemModule().withStackTraces(false);
    }

    @Bean
    public ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }
}
