package com.bupt626.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hexiuyu on 2017/1/19.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     *  todo
     * to permit csrf , but it will move to api gateway in the future
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
//    }
//
//    class CorsInterceptor extends HandlerInterceptorAdapter {
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
//            response.setHeader("Access-Control-Allow-Headers", "X-XSRF-TOKEN, Origin, X-Requested-With, Content-Type, Accept, Authorization");
//            response.setHeader("Access-Control-Max-Age", "3600");
//            return true;
//        }
//    }

    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    class CorsFilter implements Filter {

        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "X-XSRF-TOKEN, Origin, X-Requested-With, Content-Type, Accept, Authorization");
            response.setHeader("Access-Control-Max-Age", "3600");
            if (!"OPTIONS".equals(request.getMethod())) {
                chain.doFilter(req, res);
            } else {
            }
        }

        public void init(FilterConfig filterConfig) {}

        public void destroy() {}

    }


}
