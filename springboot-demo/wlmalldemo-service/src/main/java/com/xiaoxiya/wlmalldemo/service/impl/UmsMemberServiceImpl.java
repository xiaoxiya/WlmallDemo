package com.xiaoxiya.wlmalldemo.service.impl;


import com.xiaoxiya.wlmalldemo.service.RedisService;
import com.xiaoxiya.wlmalldemo.service.UmsMemberService;
import com.xiaoxiya.wlmalldemocommon.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author luopeng
 * @date 2019/8/8 17:57
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authcode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public Result generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i =0; i < 6; i++){
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone,AUTH_CODE_EXPIRE_SECONDS);
        return Result.success(sb.toString(),"获取验证码成功");
    }

    /**
     * 对输入的验证码进行校验
     */
    @Override
    public Result verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return Result.error("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return Result.success(null,"验证码校验成功");
        } else {
            return Result.error("验证码不正确");
        }
    }
}
