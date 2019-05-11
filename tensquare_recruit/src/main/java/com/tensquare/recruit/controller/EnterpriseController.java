package com.tensquare.recruit.controller;

import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述: 企业控制层
 * @作者: lj
 * @创建时间: 2019/5/11 9:41
 */
@CrossOrigin    //解决跨域问题
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/search/hostlist")
    public Result hostlist() {
        return new Result(true, StatusCode.OK, "查询成功!", enterpriseService.hostlist("1"));   //1：表示热门
    }
}
