package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述: 企业serviec
 * @作者: lj
 * @创建时间: 2019/5/11 9:36
 */
@Service
@Transactional
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 功能描述: 热门企业列表
     * @作者: lj
     * @创建时间: 2019/5/11 9:35
     */
    public List<Enterprise> hostlist(String ishot) {
        return enterpriseDao.findByIshot(ishot);
    };
}
