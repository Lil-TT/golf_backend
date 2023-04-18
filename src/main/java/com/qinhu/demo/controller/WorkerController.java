package com.qinhu.demo.controller;

import com.qinhu.demo.common.R;
import com.qinhu.demo.entity.Worker;
import com.qinhu.demo.service.RedisService;
import com.qinhu.demo.service.WorkerService;
import com.qinhu.demo.utils.HttpUtils;
import com.qinhu.demo.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qinhu.demo.common.Const;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private WorkerService workerService;

    /**
     * 小程序登录(前端登录获取token)
     *
     * @param code
     * @return
     */
    @GetMapping(value = { "/login" }, produces = { "application/json;charset=UTF-8" })
    public R<String> login(@RequestParam("code") String code) {
        try {
            String result = HttpUtils.doGet(Const.WECHAT_APP_CODESESSION.replaceAll("JSCODE", code));
            Map<String, Object> resultMap = JsonUtil.fastJsonToObj(result);
            if (!resultMap.containsKey("errcode")) {
                String openid = resultMap.get("openid").toString();
                String session_key = resultMap.get("session_key").toString();
                String userToken = Md5Util.getMD5(openid + Const.MD5 + session_key);
                this.redisService.set(Const.WECHAT_USER_TOKEN_KEY + userToken, openid + ":" + session_key);
                User user = this.userService.findByOpenId(openid);
                if (user == null) {
                    user = new User();
                    user.setId(UuidUtil.get32UUID());
                    user.setOpenId(openid);
                    user.setCreateTime(new Date());
                    this.userService.save(user);
                }
                Map<String, Object> reqMap = new HashMap<String, Object>();
                reqMap.put("userToken",userToken);
                reqMap.put("openid",openid);
                resultDto = new ResultDto(true, ErrorCode.OK, reqMap, "");
            }
        return resultDto;
    }

    @PostMapping("/addAddress")
    public R<String> addAddress(@RequestParam(value = "address", required = true) String address){
        log.info("");

        return null;
    }
}
