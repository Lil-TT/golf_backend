package com.qinhu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinhu.demo.entity.Brand;
import com.qinhu.demo.mapper.BrandMapper;
import com.qinhu.demo.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl  extends ServiceImpl<BrandMapper, Brand> implements BrandService {
}
