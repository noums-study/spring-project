package noums.study.pizzahouse.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuCheckingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // requestBody 값을 읽어서 존재하는 메뉴를 요청한건지 확인해야하는데
        // 그럴려면 inputstream을 읽어야한다.
        // 근데 inputstream은 기본적으로 1번만 읽을 수 있어서 여기서 읽어버리면 뒤에 json으로 변환되는과정에서 에러가 발생할 것이다.
        // 그렇기에 필터에서 inputstream을 2번 읽을 수 있도록 조치를 취해주고 여기서 읽어줘야 된다.

        return true;
    }


}
