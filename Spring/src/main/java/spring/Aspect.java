package spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Pointcut("execution(* *.logEvent(..))")
    private void allLoEventMethods() {

    }

    @Before("allLoEventMethods()")
    public void logDefore(JoinPoint joinPoint) {
        System.out.println("before22 " + joinPoint.getTarget().getClass().getSimpleName());
    }


}
