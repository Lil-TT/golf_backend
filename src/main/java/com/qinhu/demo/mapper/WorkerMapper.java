package com.qinhu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinhu.demo.entity.Worker;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {
}
