package aspects;

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

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        LOGGER.info("Method " + methodName +
                " with arguments " + Arrays.asList(args) + " will execute");

        Comment comment = new Comment("Altered comment in aspect!!", "Bob");
        Object[] alteredArgs = {comment};
        Object returnVal = joinPoint.proceed(alteredArgs);

        LOGGER.info("Method " + methodName + " executed and returned " + returnVal);
        return returnVal;
    }
}
