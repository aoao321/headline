package com.aoao.controller;

import com.aoao.bean.Headline;
import com.aoao.common.Result;
import com.aoao.service.HeadlineService;
import com.aoao.service.impl.HeadlineServiceImpl;
import com.aoao.utlis.JwtHelper;
import com.aoao.utlis.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aoao
 * @create 2025-02-17-15:43
 */
@WebServlet("/headline/*")
public class HeadlineController extends BaseController {
    HeadlineService headlineService = new HeadlineServiceImpl();
    /**
     * 发布新闻
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据token来获取当前用户id
        req.setCharacterEncoding("utf-8");
        String token = req.getHeader("token");
        Integer userId = JwtHelper.getUserId(token).intValue();
        //接受用户写入的文章信息
        Headline headline = WebUtil.readJSON(req, Headline.class);
        //调用服务层方法
        headlineService.addHeadline(userId,headline);
        //响应
        WebUtil.writeJSON(resp, Result.ok(null));
    }

    /**
     * 修改头条内容先要回显出原来的头条内容
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String hid = req.getParameter("hid");
        //调用服务层方法
        Headline headline = headlineService.findHeadlineByHid(hid);
        //响应
        Map data = new HashMap();
        data.put("headline", headline);
        WebUtil.writeJSON(resp, Result.ok(data));
    }

    /**
     * 修改头条更新数据库的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        req.setCharacterEncoding("utf-8");
        Headline headline = WebUtil.readJSON(req, Headline.class);
        //调用服务层
        int rows = headlineService.updateHeadline(headline);
        //响应
        if (rows > 0) {
            WebUtil.writeJSON(resp, Result.ok(null));
        }
    }

    /**
     * 删除头条接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        String hid = req.getParameter("hid");
        //调用服务层
        int rows = headlineService.removeByHid(hid);
        //响应
        if (rows > 0) {
            WebUtil.writeJSON(resp, Result.ok(null));
        }
    }
}
