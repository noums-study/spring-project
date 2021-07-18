package noums.study.pizzahouse;

import noums.study.pizzahouse.interceptor.MenuCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private MenuCheckInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("##### [WebConfiguration] addInterceptor ");
//
//        registry.addInterceptor(interceptor)
//                .addPathPatterns("/orders");
    }
}
