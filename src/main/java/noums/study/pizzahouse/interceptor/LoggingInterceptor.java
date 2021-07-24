package noums.study.pizzahouse.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggingInterceptor extends HandlerInterceptorAdapter {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("### Interceptor preHandle ");

//        if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper")) return false;
//        final RereadableRequestWrapper rereadableRequestWrapper = (RereadableRequestWrapper) request;
//        if (rereadableRequestWrapper.getContentType() != null && rereadableRequestWrapper.getContentType().contains("application/json")) {
//            if (rereadableRequestWrapper.getRawData() != null && rereadableRequestWrapper.getRawData().length != 0){
//                String data = rereadableRequestWrapper.getData();
//                System.out.println(data);
//                OrderRequest orderRequest = objectMapper.readValue(data, OrderRequest.class);
//                Menu menu = orderRequest.getMenu();
//                System.out.println(menu);
//                if (menu == Menu.NONE) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("### Interceptor postHandle ");

//        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;
//        if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
//            if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
//                System.out.println("aaaaa");
//            }
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("### Interceptor afterCompletion ");
        if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper"));
//        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
//        if (cachingRequest.getContentType() != null && cachingRequest.getContentType().contains("application/json")) {
//            if (cachingRequest.getContentAsByteArray() != null && cachingRequest.getContentAsByteArray().length != 0){
//                log.info("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray())); }
//        }
//        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;
//        if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
//            if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
//                log.info("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
//            }
//        }
    }
}
