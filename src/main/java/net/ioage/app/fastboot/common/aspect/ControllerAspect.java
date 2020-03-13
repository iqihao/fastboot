package net.ioage.app.fastboot.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by qihao01 on 2020/3/13.
 */
@Aspect
@Slf4j
@Component
public class ControllerAspect {

    @Around("execution(public * net.ioage.app.fastboot.*.*.controller.*(..))")
    public Object controllerLog(ProceedingJoinPoint pdj) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long startTime = System.currentTimeMillis();//开始时间

        Object[] args = pdj.getArgs();//获取参数数组
        Object ret = pdj.proceed(args);//执行原方法并获取返回结果

        long endTime = System.currentTimeMillis();//结束时间

        // 记录下请求内容
        StringBuilder sb = new StringBuilder();
        sb.append("==>  请求URL: " + request.getRequestURL().toString());
        sb.append("   Params: " + Arrays.toString(args));
        sb.append("   耗时: " + (endTime - startTime) + "毫秒");

        log.info(sb.toString());
        return ret;
    }
}
