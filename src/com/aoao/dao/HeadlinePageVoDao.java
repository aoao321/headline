package com.aoao.dao;

import com.aoao.bean.vo.HeadlinePageVo;
import com.aoao.bean.vo.HeadlineQueryVo;

import java.util.List;

/**
 * @author aoao
 * @create 2025-02-26-11:07
 */
public interface HeadlinePageVoDao {
    /**
     * 查询满足条件的头条总数目
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

}
