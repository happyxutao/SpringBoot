package cn.login.Controller;

import cn.login.common.Result;
import cn.login.exception.MyBusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ExceptionController {
    /**
     * 系统内部错误
     */
    @GetMapping("/exception")
    public Result testException() {
        int i = 1 / 0;
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData("cc");
        return result;
    }
    /**
     * 自定义异常
     */
    @GetMapping("/myException")
    public Result testMyexception() {
        throw new MyBusinessException(508, "自定义的异常");
    }
}
