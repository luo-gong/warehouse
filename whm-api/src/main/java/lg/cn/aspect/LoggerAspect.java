package lg.cn.aspect;

import lg.cn.aspect.pointcut.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {


    @Pointcut("execution(public * lg.cn.server.TestAsPect.testMethod(..))")
    public void loggerPointCut() {

    }


    /**
     * 注解方式：如果需要对某一方法进行增强，只需要在相应的方法上添加上自定义注解即可
     *
     * @param proceedingJoinPoint
     * @param around
     * @return
     * @throws Throwable
     */
    @SuppressWarnings("all")
    @Around(value = "@annotation(around)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, MyAnnotation around) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        args[0] = "gongjing";
        Object result = proceedingJoinPoint.proceed(args);
        System.out.println("MyAnnotation" + around.methoname());
        System.out.println(result);
        return result;
    }



  /*  @Before(value = "execution(public * lg.cn.marketsecurity.server.TestAspect.testMethod(..))")
    public void before(JoinPoint jp) {
        System.out.println("target" + jp.getTarget());
    }
*/

//    /**
//     * @param result
//     * @param jp
//     * @throws Throwable
//     * @param2 是JoinPoint不是Joinpoint
//     */
//    @SuppressWarnings("all")
//    @AfterReturning(value = "loggerPointCut()", returning = "result", argNames = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) throws Throwable {
//        System.out.println("kind>>>>>>" + joinPoint.getKind());//连接点类型
//        System.out.println("this>>>>>>" + joinPoint.getThis());//返回AOP代理对象
//        System.out.println("连接点位置" + joinPoint.toLongString());//连接点所在位置的全部相关信息
//        System.out.println("Args>>>>>>" + objectMapper.writeValueAsString(joinPoint.getArgs()));
//        System.out.println("result" + result);
//    }


}
