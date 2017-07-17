package com.bupt626;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class AccountServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServerApplication.class, args);
	}

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
