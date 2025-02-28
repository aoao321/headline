package com.aoao.service;

import com.aoao.bean.Headline;
import com.aoao.bean.vo.HeadlineDetailVo;
import com.aoao.bean.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * @author aoao
 * @create 2025-02-17-15:27
 */
public interface HeadlineService {
    /**
     * 查询分页的功能实现
     * @param headlineQueryVo
     * @return
     */
    Map findPage(HeadlineQueryVo headlineQueryVo);

    /***
     * 查询具体头条页面功能实现
     * @param hid 根据hid来查询
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     * 添加一条头条消息
     *
     * @param userId
     * @param headline
     * @return
     */
    int addHeadline(Integer userId, Headline headline);

    /**
     * 查询头条
     * @param hid
     * @return
     */
    Headline findHeadlineByHid(String hid);

    /**
     * 修改头条内容
     * @param headline
     * @return
     */
    int updateHeadline(Headline headline);

    /**
     * 删除头条内容
     * @param hid
     * @return
     */
    int removeByHid(String hid);
}
