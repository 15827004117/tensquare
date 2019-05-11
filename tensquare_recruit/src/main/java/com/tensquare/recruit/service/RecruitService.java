package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述: 招聘信息
 * @作者: lj
 * @创建时间: 2019/5/11 10:59
 */
@Service
@Transactional
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 功能描述: 根据状态查询(2 = 推荐)
     * @作者: lj
     * @创建时间: 2019/5/11 10:58
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 功能描述: 根据状态查询( !=0 最新)
     * @作者: lj
     * @创建时间: 2019/5/11 11:15
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc(state);
    }
}
