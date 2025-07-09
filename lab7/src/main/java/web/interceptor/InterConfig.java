package web.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class InterConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor auth;

    @Autowired
    GlobalInterceptor global;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(global)
            .addPathPatterns("/**")
            .excludePathPatterns("/assets/**");

        registry.addInterceptor(auth)
            .addPathPatterns("/account/edit", "/account/chgpwd", "/order/**", "/admin/**")
            .excludePathPatterns("/assets/**", "/admin/home/index");
    }
}
