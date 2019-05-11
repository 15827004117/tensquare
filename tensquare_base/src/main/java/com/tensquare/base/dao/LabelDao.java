package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 功能描述:    标签数据访问接口
 * JpaRepository:用于基本crud
 * JpaSpecificationExecutor：用于复杂的条件查询
 * @作者: lj
 * @创建时间: 2019/5/10 8:16
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
