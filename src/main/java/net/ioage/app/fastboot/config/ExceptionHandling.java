package net.ioage.app.fastboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

/**
 * Created by qihao01 on 2019/5/29.
 */
@ControllerAdvice
public class ExceptionHandling implements ProblemHandling, SecurityAdviceTrait {
    @Override
    public boolean isCausalChainsEnabled() {
        return true;
    }
}
