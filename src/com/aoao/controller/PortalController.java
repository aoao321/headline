package com.aoao.controller;

import com.aoao.bean.Type;
import com.aoao.bean.vo.HeadlineDetailVo;
import com.aoao.bean.vo.HeadlinePageVo;
import com.aoao.bean.vo.HeadlineQueryVo;
import com.aoao.common.Result;
import com.aoao.service.HeadlineService;
import com.aoao.service.TypeService;
import com.aoao.service.impl.HeadlineServiceImpl;
import com.aoao.service.impl.TypeServiceImpl;
import com.aoao.utlis.WebUtil;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户 控制器
 * 不需要登录，不需要增删改的请求
 *
 * @author aoao
 * @create 2025-02-17-16:10
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private TypeService typeService = new TypeServiceImpl();
    private HeadlineService headlineService = new HeadlineServiceImpl();

    /**
     * 查询所有头条类型业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的新闻类型
        List<Type> newsType = typeService.findAll();
        //装入result
        Result result = new Result();
        result = Result.ok(newsType);
        //转换成JSON串
        WebUtil.writeJSON(resp,result);
    }

    /**
     * 分页查询的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受请求的json串
        req.setCharacterEncoding("UTF-8");
        HeadlineQueryVo headlineQueryVo = WebUtil.readJSON(req,HeadlineQueryVo.class);
        //调用服务层方法查询数据
        Map pageInfo = headlineService.findPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo", pageInfo);
        //响应
        WebUtil.writeJSON(resp,Result.ok(data));
    }

    /**
     * 展示头条具体内容的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取头条的hid来获取头条的具体内容
        int hid = Integer.parseInt(req.getParameter("hid"));
        //调用service层来实现业务
        HeadlineDetailVo headlineDetailVo = headlineService.findHeadlineDetail(hid);
        //响应查询到的数据
        Map data = new HashMap();
        data.put("headline",headlineDetailVo);
        resp.setCharacterEncoding("UTF-8");
        WebUtil.writeJSON(resp,Result.ok(data));
    }
}
