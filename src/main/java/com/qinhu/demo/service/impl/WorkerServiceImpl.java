package com.qinhu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinhu.demo.entity.Worker;
import com.qinhu.demo.mapper.WorkerMapper;
import com.qinhu.demo.service.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements WorkerService {

}
