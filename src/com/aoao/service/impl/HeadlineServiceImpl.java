package com.aoao.service.impl;

import com.aoao.bean.Headline;
import com.aoao.bean.vo.HeadlineDetailVo;
import com.aoao.bean.vo.HeadlinePageVo;
import com.aoao.bean.vo.HeadlineQueryVo;
import com.aoao.dao.HeadlineDao;
import com.aoao.dao.HeadlineDetailVoDao;
import com.aoao.dao.HeadlinePageVoDao;
import com.aoao.dao.impl.HeadlineDaoImpl;
import com.aoao.dao.impl.HeadlineDetailVoDaoImpl;
import com.aoao.dao.impl.HeadlinePageVoDaoImpl;
import com.aoao.service.HeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aoao
 * @create 2025-02-17-15:25
 */
public class HeadlineServiceImpl implements HeadlineService {
    private HeadlineDao headlineDao = new HeadlineDaoImpl();
    private HeadlineDetailVoDao headlineDetailVoDao = new HeadlineDetailVoDaoImpl();
    private HeadlinePageVoDao headlinePageVoDao = new HeadlinePageVoDaoImpl();

    @Override
    public Map findPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        //调用dao层方法查询具体符合筛选结果的头条信息
        List<HeadlinePageVo> pageData = headlinePageVoDao.findPageList(headlineQueryVo);
        //满足条件的头条总数目
        int totalSize = headlineDao.findPageCount(headlineQueryVo);
        //总页码数
        int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageNum", pageNum);
        pageInfo.put("pageSize", pageSize);
        pageInfo.put("totalSize", totalSize);
        pageInfo.put("totalPage", totalPage);
        pageInfo.put("pageData", pageData);

        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        //使头条的浏览量+1
        int incrPageViews = headlineDao.incrPageViews(hid);
        //查询头条详情
        HeadlineDetailVo headlineDetail = headlineDetailVoDao.findHeadlineDetail(hid);

        return headlineDetail;
    }

    @Override
    public int addHeadline(Integer userId, Headline headline) {
        return headlineDao.addHeadline(userId,headline);
    }

    @Override
    public Headline findHeadlineByHid(String hid) {
        return headlineDao.findHeadlineByHid(hid);
    }

    @Override
    public int updateHeadline(Headline headline) {
        return headlineDao.updateByHid(headline);
    }

    @Override
    public int removeByHid(String hid) {
        return headlineDao.removeByHid(hid);
    }
}
