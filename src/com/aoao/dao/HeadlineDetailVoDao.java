package com.aoao.dao;

import com.aoao.bean.vo.HeadlineDetailVo;

/**
 * @author aoao
 * @create 2025-02-26-11:03
 */
public interface HeadlineDetailVoDao {
    /**
     * 查询具体头条页面功能实现
     * @param hid 根据hid查询
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(int hid);
}
