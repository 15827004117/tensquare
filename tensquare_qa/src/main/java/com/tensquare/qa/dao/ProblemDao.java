package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;



/**
 * 功能描述: 问题数据接口
 * @作者: lj
 * @创建时间: 2019/5/11 11:56
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    /**
     * 功能描述: 根据标签id查询最新问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 12:21
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY replytime DESC", nativeQuery = true)
    Page<Problem> newlist(String labelid, Pageable pageable);

    /**
     * 功能描述: 根据标签id查询最热问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 12:21
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY reply DESC", nativeQuery = true)
    Page<Problem> hostlist(String labelid, Pageable pageable);

    /**
     * 功能描述: 根据标签id查询等待回答问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 12:21
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? AND reply = 0 ORDER BY createtime DESC", nativeQuery = true)
    Page<Problem> waitlist(String labelid, Pageable pageable);
}
