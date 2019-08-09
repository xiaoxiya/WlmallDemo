package com.xiaoxiya.wlmalldemo.service;

import com.xiaoxiya.wlmalldemomodel.Comment.Result;


/**
 * @author luopeng
 * @date 2019/8/8 17:35
 * 会员管理service
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    Result generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    Result verifyAuthCode(String telephone, String authCode);

}
