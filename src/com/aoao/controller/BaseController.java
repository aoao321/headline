package com.aoao.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author aoao
 * @create 2025-02-17-15:57
 */


public abstract class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断此时请求是什么增删改查
        String uri = req.getRequestURI();
        String[] split = uri.split("/");
        String methodName = split[split.length - 1];

        //通过方法名获取方法
        Class aClass = this.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
