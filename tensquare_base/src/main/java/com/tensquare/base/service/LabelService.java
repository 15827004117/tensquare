package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:    标签业务逻辑类
 * @作者: lj
 * @创建时间: 2019/5/10 8:19
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 功能描述: 构建查询条件
     * @作者: lj
     * @创建时间: 2019/5/10 13:13
     */
    private Specification<Label> createpecification(Label label) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //new一个list存放所有查询条件
                List<Predicate> list = new ArrayList();
                //模糊查询条件
                if(label.getLabelname()!=null && !label.getLabelname().equals("")) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(label.getState()!=null && !label.getState().equals("")) {
                    criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                }
                if(label.getRecommend()!=null && label.getRecommend().equals("")) {
                    criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
    }

    /**
     * 功能描述: 查询全部
     * @作者: lj
     * @创建时间: 2019/5/10 8:20
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 功能描述: 根据id查询标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:21
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 功能描述: 增加标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:22
     */
    public void add(Label label) {
        label.setId( idWorker.nextId() + "");  //设置id
        labelDao.save(label);
    }

    /**
     * 功能描述: 修改标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:23
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 功能描述: 删除标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:24
     */
    public void deteleById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 功能描述: 根据条件查询
     * @作者: lj
     * @创建时间: 2019/5/10 10:38
     */
    public List<Label> findSearch(Label label) {
        Specification specification = createpecification(label);
        return labelDao.findAll(specification);
    }

    /**
     * 功能描述: 分页条件查询
     * @作者: lj
     * @创建时间: 2019/5/10 10:38
     */
    public Page<Label> findSearch(Label label ,int page, int size) {
        Specification specification = createpecification(label);
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll(specification, pageable);
    }
}
