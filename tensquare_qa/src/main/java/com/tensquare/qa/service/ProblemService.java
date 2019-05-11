package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 功能描述: 回答
 * @作者: lj
 * @创建时间: 2019/5/11 14:25
 */
@Service
@Transactional
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    /**
     * 功能描述: 最新问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:47
     */
    public Page<Problem> newlist(String labelid, int page, int rows) {
        Pageable pageable = PageRequest.of(page -1, rows);
        return problemDao.newlist(labelid,pageable);
    }

    /**
     * 功能描述: 最热问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:47
     */
    public Page<Problem> hostlist(String labelid, int page, int rows) {
        Pageable pageable = PageRequest.of(page -1, rows);
        return problemDao.hostlist(labelid,pageable);
    }

    /**
     * 功能描述: 等待回答问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:47
     */
    public Page<Problem> waitlist(String labelid, int page, int rows) {
        Pageable pageable = PageRequest.of(page -1, rows);
        return problemDao.newlist(labelid,pageable);
    }
}
