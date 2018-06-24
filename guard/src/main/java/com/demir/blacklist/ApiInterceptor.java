package com.demir.blacklist;

import com.demir.blacklist.control.BlackListManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 13:20
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {

    @Inject
    IpAddressParser ipAddressParser;
    @Inject
    BlackListManager manager;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        checkIp(ipAddressParser.getClientIpAddress(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        checkIp(ipAddressParser.getClientIpAddress(request));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    private void checkIp(final String ip) {
        boolean ipBanned = manager.checkIpAddress(ip);
        if (ipBanned) {
            throw new IllegalIpAccessException();
        }
    }
}
