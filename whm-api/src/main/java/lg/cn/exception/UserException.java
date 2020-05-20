package lg.cn.exception;


import com.baomidou.mybatisplus.extension.api.IErrorCode;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);
    }

}
