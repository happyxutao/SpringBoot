package cn.login.Controller;

import cn.login.common.MyCustomEvent;
import cn.login.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
/**
 * 模拟触发事件
 */
@RestController
@RequestMapping("/event")
@Slf4j
public class EventDemoController {
    /**
     * 注入 事件发布类
     */
    @Autowired
    ApplicationEventPublisher eventPublisher;
    @GetMapping("/pushObject")
    public String pushObject(@RequestParam("code") int code,@RequestParam("message") String message) {
        log.info("发布对象事件:{},{}", code, message);
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        MyCustomEvent myCustomEvent = new MyCustomEvent(this, result);
        eventPublisher.publishEvent(myCustomEvent);
        return "对象事件发布成功!";
    }
}
