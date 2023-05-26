package cn.login;

import cn.login.Listener.MyEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        //加入自定义的监听类
        application.addListeners(new MyEventListener());
        application.run(args);
        //SpringApplication.run(Application.class, args);
    }
}
