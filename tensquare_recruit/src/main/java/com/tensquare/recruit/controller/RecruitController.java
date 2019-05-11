package com.tensquare.recruit.controller;

import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述: 招聘信息控制层
 * @作者: lj
 * @创建时间: 2019/5/11 11:00
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    /**
     * 功能描述: 推荐职位列表
     * @作者: lj
     * @创建时间: 2019/5/11 11:13
     */
    @GetMapping("/search/recommend")
    public Result recommend() {
        return new Result(true, StatusCode.OK, "查询成功!", recruitService.findTop4ByStateOrderByCreatetimeDesc("2"));  //2表示推荐
    }

    /**
     * 功能描述: 最新职位列表
     * @作者: lj
     * @创建时间: 2019/5/11 11:13
     */
    @GetMapping("/search/newlist")
    public Result newlist() {
        return new Result(true, StatusCode.OK, "查询成功!", recruitService.findTop12ByStateNotOrderByCreatetimeDesc("0"));  //0表示关闭
    }
}
