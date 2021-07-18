package noums.study.pizzahouse.filter;

import noums.study.pizzahouse.bean.RereadableRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletWrappingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("##### ServletWrappingFilter doFilterInternal");

        RereadableRequestWrapper rereadableRequestWrapper = new RereadableRequestWrapper(httpServletRequest);
        /* HttpServletRequest wrapper that caches all content read from the input stream and reader, and allows this content to be retrieved via a byte array. */
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
        filterChain.doFilter(rereadableRequestWrapper, responseWrapper);
        responseWrapper.copyBodyToResponse();
    }
}
