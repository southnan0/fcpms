package com.czn.fcpms.interceptor;

import com.czn.fcpms.annotation.Authorization;
import com.czn.fcpms.common.ExceptionUtil;
import com.czn.fcpms.common.TokenUtil;
import com.czn.fcpms.enums.ResultEnum;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private TokenUtil tokenUtil;
    private ResultEnum resultEnum;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        Authorization authorization;
        if (handler instanceof HandlerMethod){
            authorization = ((HandlerMethod) handler).getMethodAnnotation(Authorization.class);
        }else {
            return true;
        }

        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        if(request.getRequestURI().equals("/account/login")){
            return true;
        }
        if (authorization != null){
            String token = request.getHeader("Authorization");
            Object j = tokenUtil.parseToken(token);
            if(j != null){
                return true;
            }
        }

        response.setStatus(401);
        return false;
//        throw new ExceptionUtil(resultEnum.TOKEN_ERROR);
    }
}
