package com.aoao.utlis;

/**
 * @author aoao
 * @create 2025-02-15-16:07
 */
import com.aoao.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public final class WebUtil {
    private static ObjectMapper mapper;
    static
    {
        mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    //用于转化成JSON串的方法
    public static void writeJSON(HttpServletResponse resp,Result result) {
        //设置响应头
        resp.setContentType("application/json;charset=utf-8");
        // 输出信息
        try {
            String json = mapper.writeValueAsString(result);
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T readJSON(HttpServletRequest req,Class<T> clazz) {
        T t = null;
        BufferedReader reader = null;
        try {
            reader = req.getReader();
            StringBuilder buffer = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            t = mapper.readValue(buffer.toString(),clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
