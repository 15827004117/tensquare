package com.tensquare.qa.controller;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述: 问题控制层
 * @作者: lj
 * @创建时间: 2019/5/11 14:47
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 功能描述: 最新问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:51
     */
    @GetMapping("/newlist/{labelid}/{page}/{size}")
    public Result newlist(@PathVariable String labelid,
                          @PathVariable int page,
                          @PathVariable int size) {
        Page<Problem> newlist = problemService.newlist(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功!",
                new PageResult<Problem>(newlist.getTotalElements(), newlist.getContent()));
    }

    /**
     * 功能描述: 最热问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:51
     */
    @GetMapping("/hostlist/{labelid}/{page}/{size}")
    public Result hostlist(@PathVariable String labelid,
                           @PathVariable int page,
                           @PathVariable int size) {
        Page<Problem> hostlist = problemService.hostlist(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功!",
                new PageResult<Problem>(hostlist.getTotalElements(), hostlist.getContent()));
    }

    /**
     * 功能描述: 等待回答问题列表
     * @作者: lj
     * @创建时间: 2019/5/11 14:51
     */
    @GetMapping("/waitlist/{labelid}/{page}/{size}")
    public Result waitlist(@PathVariable String labelid,
                           @PathVariable int page,
                           @PathVariable int size) {
        Page<Problem> waitlist = problemService.waitlist(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功!",
                new PageResult<Problem>(waitlist.getTotalElements(), waitlist.getContent()));
    }

}
