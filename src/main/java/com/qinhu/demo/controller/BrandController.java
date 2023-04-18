package com.qinhu.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinhu.demo.common.R;
import com.qinhu.demo.entity.Brand;
import com.qinhu.demo.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/page")
    public R<Page> GetBrandList(int page, int pageSize){
        log.info("page={},pageSize={}",page,pageSize);

        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Brand> queryWrapper = new LambdaQueryWrapper<>();
        // 添加排序条件
        queryWrapper.orderByDesc(Brand::getId);
        //执行查询
        brandService.page(pageInfo, queryWrapper);


        return R.success(pageInfo);
    }

    @PostMapping("/one")
    public Brand GetOne(@RequestParam() int id ) {
        return brandService.getById(id);
    }
}
