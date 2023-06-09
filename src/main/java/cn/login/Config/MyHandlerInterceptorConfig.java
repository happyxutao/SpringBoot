package cn.login.Config;

import cn.login.Interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyHandlerInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private MyHandlerInterceptor myHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor
                (myHandlerInterceptor);
//所有路径都被拦截
        registration.addPathPatterns("/**");
//添加不拦截路径
        registration.excludePathPatterns(
                "/**/*.html", //HTML静态资源
                "/**/*.js", //JS静态资源
                "/**/*.css" //CSS静态资源
        );
    }
}