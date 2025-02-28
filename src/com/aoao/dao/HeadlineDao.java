package com.aoao.dao;

import com.aoao.bean.Headline;
import com.aoao.bean.vo.HeadlineQueryVo;

/**
 * @author aoao
 * @create 2025-02-17-15:09
 */

public interface HeadlineDao {
    /**
     * 查询具体符合筛选结果的头条信息
     * @param headlineQueryVo 传入QueryVo中的头条类型type和关键字keyword
     * @return
     */

    int findPageCount(HeadlineQueryVo headlineQueryVo);



    /**
     * 使头条浏览量+1
     * @param hid
     * @return
     */
    int incrPageViews(int hid);

    /**
     * 添加一条头条信息
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
     * 修改数据库
     * @param headline
     * @return
     */
    int updateByHid(Headline headline);

    /**
     * 删除头条
     * @param hid
     * @return
     */
    int removeByHid(String hid);
}
