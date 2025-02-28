package com.aoao.dao.impl;

import com.aoao.bean.vo.HeadlineDetailVo;
import com.aoao.dao.BaseDao;
import com.aoao.dao.HeadlineDetailVoDao;
import com.aoao.utlis.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aoao
 * @create 2025-02-26-11:02
 */
public class HeadlineDetailVoDaoImpl extends BaseDao<HeadlineDetailVo> implements HeadlineDetailVoDao {
    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        try(Connection connection = JDBCUtil.getConnection()){
            String sql =
            "select " +
                    "h.hid hid," +
                    "h.title title," +
                    "h.article article," +
                    "h.type type," +
                    "t.tname typeName," +
                    "h.page_views pageViews," +
                    "TIMESTAMPDIFF(HOUR,create_time,now()) pastHours," +
                    "h.publisher publisher," +
                    "u.nick_name author " +
            "from " +
                    "news_headline h," +
                    "news_type t," +
                    "news_user u" +
            " where " +
                    "h.type=t.tid " +
           " and" +
                    " h.publisher=u.uid "+
           " and" +
                    " hid=?" ;

            return getInstance(connection, sql, hid);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
