package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;



/**
 * 功能描述: 标签控制层
 * @作者: lj
 * @创建时间: 2019/5/10 8:29
 */
@CrossOrigin    //解决跨域问题
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 功能描述: 查询全部
     * @作者: lj
     * @创建时间: 2019/5/10 8:20
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功!", labelService.findAll());
    }

    /**
     * 功能描述: 根据id查询标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:21
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功!", labelService.findById(id));
    }

    /**
     * 功能描述: 增加标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:22
     */
    @PostMapping
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "添加成功!");
    }

    /**
     * 功能描述: 修改标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:23
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功!");
    }

    /**
     * 功能描述: 删除标签
     * @作者: lj
     * @创建时间: 2019/5/10 8:24
     */
    @DeleteMapping("/{id}")
    public Result deteleById(@PathVariable String id) {
        labelService.deteleById(id);
        return new Result(true, StatusCode.OK, "删除成功!");
    }

    /**
     * 功能描述: 根据条件查询
     * @作者: lj
     * @创建时间: 2019/5/10 10:16
     */
    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label) {
        return new Result(true, StatusCode.OK, "查询成功!", labelService.findSearch(label));
    }

    /**
     * 功能描述: 根据条件分页查询
     * @作者: lj
     * @创建时间: 2019/5/10 10:16
     */
    @PostMapping("/search/{page}/{size}")
    public Result findSearch2(@RequestBody Label label,
                             @PathVariable int page,
                             @PathVariable int size) {
        Page<Label> pageData = labelService.findSearch(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功!",
                new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }


}
