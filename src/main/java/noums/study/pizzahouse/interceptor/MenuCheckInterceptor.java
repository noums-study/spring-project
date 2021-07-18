package noums.study.pizzahouse.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.bean.RereadableRequestWrapper;
import noums.study.pizzahouse.enums.Menu;
import org.apache.commons.lang3.EnumUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MenuCheckInterceptor implements HandlerInterceptor {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("##### [Interceptor] MenuCheckInterceptor preHandle");

        /* 시큐리티에서 RequestWrapper를 사용하는데 이 부분과 충돌나서 만약 이미 시큐리티에서 래핑한 클래스일 경우 다시 래핑하지 않도록 한다. */
        if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper")) return false;
        final RereadableRequestWrapper rereadableRequestWrapper = (RereadableRequestWrapper) request;
        if (rereadableRequestWrapper.getContentType() != null && rereadableRequestWrapper.getContentType().contains("application/json")) {
            if (rereadableRequestWrapper.getRawData() != null && rereadableRequestWrapper.getRawData().length != 0) {
                String data = rereadableRequestWrapper.getData();
                System.out.println("data = " + data);
                JSONObject mapper = new JSONObject(data);
                if (!EnumUtils.isValidEnum(Menu.class, mapper.getString("menu"))) {
                    System.out.println("##### [Interceptor] Invalid menu ");
                    return false;
                }
            }
        }
        return true;
    }


}
