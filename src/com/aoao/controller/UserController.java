package com.aoao.controller;

import com.aoao.bean.Type;
import com.aoao.bean.User;
import com.aoao.common.Result;
import com.aoao.common.ResultCodeEnum;
import com.aoao.service.TypeService;
import com.aoao.service.UserService;
import com.aoao.service.impl.TypeServiceImpl;
import com.aoao.service.impl.UserServiceImpl;
import com.aoao.utlis.JwtHelper;
import com.aoao.utlis.MD5Util;
import com.aoao.utlis.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aoao
 * @create 2025-02-17-15:51
 */
@WebServlet("/user/*")
public class UserController extends BaseController{
    private UserService userService = new UserServiceImpl();


    /**
     * 用户登录表单提交的业务接口实现
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求参数，用户名和密码(以JSON串的形式)
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
        User user = WebUtil.readJSON(req,User.class);
        //调用服务层方法，实现登录
        User loginUser = userService.findByUsername(user.getUsername());
        //通过result响应给前端
        Result result =null;
        if(null != loginUser) {
            //判断加密后密码是否一致
            if (MD5Util.encrypt(user.getPassword()).equals(loginUser.getPassword())) {
                //获取token
                String token = JwtHelper.createToken(loginUser.getUid().longValue());
                //放入Map中
                Map data = new HashMap();
                data.put("token", token);
                result = Result.ok(data);
            }else{
                result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        //未查询到该用户
        }else{
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //向客户端响应登录验证信息
        WebUtil.writeJSON(resp,result);
    }

    /**
     * 根据token口令获得用户信息的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求中的token(以请求头的方式)
        String token = req.getHeader("token");
        Result result = null;
        //校验token
        if(null != token && ("" != token)) {
            if (!JwtHelper.isExpiration(token)) {//没过期
                Integer userId = JwtHelper.getUserId(token).intValue();
                //查询用户信息
                User loginUser = userService.findByUserId(userId);
                //通过校验查询用户信息放入Result
                if(null != loginUser) {
                    //设置密码为空
                    loginUser.setPassword("");
                    Map data = new HashMap();
                    data.put("loginUser",loginUser);
                    result = Result.ok(data);
                }
            }
        }else{
            result = Result.build(null,ResultCodeEnum.NOT_LOGIN);
    }
        WebUtil.writeJSON(resp,result);
    }

    /**
     * 用于检测注册时用户名是否被占用的接口实现
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户账号
        String username = req.getParameter("username");
        //调用服务层方法 查询是否存在用户
        User newsUser = userService.findByUsername(username);
        //判断
        Result result = null;
        if (null == newsUser) {
            result = Result.ok(null);
        }else {
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        //响应JSON串
        WebUtil.writeJSON(resp,result);
    }

    /**
     * 用于注册提交表单的接口实现
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受JSON信息
        User user = WebUtil.readJSON(req, User.class);
        //调用服务层将用户存入数据库
        Integer rows = userService.registUser(user);
        //根据存入影响行数响应result
        Result result = null;
        if (rows > 0) {
            result = Result.ok(null);
        }else {
            result = Result.build(null,ResultCodeEnum.USERNAME_EXIST);
        }
        //响应
        WebUtil.writeJSON(resp,result);
    }

    /**
     * 前端自己校验是否失去状态的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取token
        String token = req.getHeader("token");
        Result result = Result.build(null,ResultCodeEnum.NOT_LOGIN);
        if(null != token) {
            if (!JwtHelper.isExpiration(token)) {
                result = Result.ok(null);
            }
        }
        WebUtil.writeJSON(resp,result);
    }
}
