package logging;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        LOGGER.info("Method " + methodName +
                " with arguments " + Arrays.asList(args) + " will execute");

        Object returnVal = joinPoint.proceed();

        LOGGER.info("Method " + methodName + " executed and returned " + returnVal);
        return returnVal;
    }
}
