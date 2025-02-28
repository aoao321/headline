package com.aoao.filters;

import com.aoao.common.Result;
import com.aoao.common.ResultCodeEnum;
import com.aoao.utlis.JwtHelper;
import com.aoao.utlis.WebUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author aoao
 * @create 2025-02-28-10:24
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取token
        String token = request.getHeader("token");
        boolean flag = false;
        if (token != null && !JwtHelper.isExpiration(token)) {
            flag = true;
        }
        if(flag = true){
            filterChain.doFilter(request, response);
        }else{
            WebUtil.writeJSON(response, Result.build(null, ResultCodeEnum.NOT_LOGIN));
        }
    }
}
