package com.aoao.test;

import com.aoao.utlis.JwtHelper;
import org.junit.Test;

/**
 * @author aoao
 * @create 2025-02-21-13:26
 */
public class JwtTest {
    @Test
    public void test() {
        //生成密文
        String token = JwtHelper.createToken(1l);
        System.out.println(token);
        //通过token获取用户id
        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);
        //验证是否超时
        boolean isExpiration = JwtHelper.isExpiration(token);
        System.out.println(isExpiration);
    }
}
