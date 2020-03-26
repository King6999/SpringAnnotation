package jx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Before("execution(public int jx.aop.MathCalculator.*(..))")
    public void logStrat(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"方法运行，参数列表是："+ Arrays.asList(args).toString()+"+}。");
    }

    @After("execution(public int jx.aop.MathCalculator.*(..))")
    public void logEnd(){
        System.out.println("方法运行结束。。。。。。");
    }

    @AfterReturning(value = "execution(public int jx.aop.MathCalculator.*(..))",returning = "result")
    public void logReturn(Object result){
        System.out.println("方法运行结束，返回结果是："+result+"");
    }

    @AfterThrowing(value = "execution(public int jx.aop.MathCalculator.*(..))", throwing = "exception")
    public void logException(Object exception){
        System.out.println("方法出现异常。。。。"+exception.toString());
    }
}
