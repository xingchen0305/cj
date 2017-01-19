package com.qydcos.be.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Component
@SessionAttributes("authorizationRequest")
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    ClientDetailsService clientService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        DefaultSavedRequest savedRequest = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication instanceof AnonymousAuthenticationToken) {
            try {
                savedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
            } catch (Exception e) {}
        }
        if (savedRequest != null) {
            try {
                Map<String, String[]> parameterMap = savedRequest.getParameterMap();
                String[] clientIds = parameterMap.get("client_id");
                if (clientIds == null || clientIds.length == 0) {
                    throw new InvalidClientException("invalid_client_id");
                }
                ClientDetails clientDetails = clientService.loadClientByClientId(clientIds[0]);
                if (clientDetails == null) {
                    throw new InvalidClientException("invalid_client_id");
                }
            } catch (Exception e) {
                LOGGER.error("Request OAuth2 login error!", e);
                modelAndView.addObject("clientError", e.getMessage());
                modelAndView.setViewName("client-error");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
