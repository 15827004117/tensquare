package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 功能描述: 招聘信息数据接口
 * @作者: lj
 * @创建时间: 2019/5/11 9:22
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 功能描述: 查询最新职位列表（按创建时间降序排序）
     * @作者: lj
     * @创建时间: 2019/5/11 10:56
     */
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 功能描述: 最新职位列表
     * @作者: lj
     * @创建时间: 2019/5/11 11:15
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);

}
