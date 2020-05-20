package lg.cn.exception;

import lg.cn.to.CommonResult;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * Created by macro on 2020/2/27.
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = UserException.class)
    public CommonResult handle(UserException e) {
        if (e.getMessage() != null) {
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }
}
