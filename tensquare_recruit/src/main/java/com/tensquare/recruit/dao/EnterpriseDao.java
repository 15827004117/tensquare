package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 功能描述: 公司信息数据接口
 * @作者: lj
 * @创建时间: 2019/5/11 9:21
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 功能描述: 根据热门状态获取企业列表
     * @作者: lj
     * @创建时间: 2019/5/11 9:35
     */
    public List<Enterprise> findByIshot(String ishot);
}
