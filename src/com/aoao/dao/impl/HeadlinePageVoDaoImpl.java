package com.aoao.dao.impl;

import com.aoao.bean.vo.HeadlinePageVo;
import com.aoao.bean.vo.HeadlineQueryVo;
import com.aoao.dao.BaseDao;
import com.aoao.dao.HeadlinePageVoDao;
import com.aoao.utlis.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aoao
 * @create 2025-02-26-11:06
 */
public class HeadlinePageVoDaoImpl extends BaseDao<HeadlinePageVo> implements HeadlinePageVoDao {
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        String sql = "select " +
                "hid as hid," +
                "title as title," +
                "type as type," +
                "page_views as pageViews," +
                "TIMESTAMPDIFF(HOUR,create_time,now()) as pastHours," +
                "publisher as publisher " +
                "from " +
                "news_headline " +
                "where " +
                "is_deleted=0 ";
        List<Object> params = new ArrayList<>();

        // 选择头条类型
        if (headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type = ? ");
            params.add(headlineQueryVo.getType());
        }
        // 根据用户输入字符串模糊查询
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().equals("")) {
            System.out.println(headlineQueryVo.getKeyWords());
            sql = sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }
        // 排序
        sql = sql.concat(" order by pastHours ASC ,pageViews DESC");
        // 分页
        sql = sql.concat(" limit ?,?");
        // 计算偏移量
        int offset = (headlineQueryVo.getPageNum() - 1) * headlineQueryVo.getPageSize();
        // 添加偏移量参数
        params.add(offset);
        // 添加每页记录数参数
        params.add(headlineQueryVo.getPageSize());

        try (Connection connection = JDBCUtil.getConnection()) {
            return getList(connection, sql, params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
