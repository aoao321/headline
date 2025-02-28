package com.aoao.dao.impl;

import com.aoao.bean.Headline;
import com.aoao.bean.vo.HeadlineQueryVo;
import com.aoao.dao.BaseDao;
import com.aoao.dao.HeadlineDao;
import com.aoao.utlis.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aoao
 * @create 2025-02-17-15:10
 */
public class HeadlineDaoImpl extends BaseDao<Headline> implements HeadlineDao {


    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        String sql = "select " +
                "count(1)" +
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
            sql = sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }
        try (Connection connection = JDBCUtil.getConnection()) {
            Long count = getValue(connection, sql, params.toArray());
            return count != null ? count.intValue() : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public int incrPageViews(int hid) {
        try(Connection connection = JDBCUtil.getConnection()){
            String sql = "update news_headline set page_views=page_views+1 where hid=?";
            return update(connection, sql, hid);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addHeadline(Integer userId, Headline headline) {
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "insert into news_headline values(DEFAULT,?,?,?,?,0,now(),now(),0) ";
            return update(connection,sql,headline.getTitle(),headline.getArticle(),headline.getType(),userId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Headline findHeadlineByHid(String hid) {
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "select hid,title,article,type from news_headline where hid=?";
            return getInstance(connection, sql, hid);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByHid(Headline headline) {
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "update news_headline set type=? ,title=?,article=? where hid=?";
            return update(connection, sql, headline.getType(),headline.getTitle(),headline.getArticle(),headline.getHid());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeByHid(String hid) {
        try(Connection connection = JDBCUtil.getConnection()){
            String sql = "delete from news_headline where hid=?";
            return update(connection, sql, hid);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


}
