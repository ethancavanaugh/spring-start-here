package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class SecurityAspect {
    private final Logger LOGGER = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        LOGGER.info("Security Aspect: Calling method " + methodName +
                " with arguments " + Arrays.asList(args));

        Object returnVal = joinPoint.proceed();

        LOGGER.info("Security aspect: Executed " + methodName + " and returned " + returnVal);

        return returnVal;
    }
}
