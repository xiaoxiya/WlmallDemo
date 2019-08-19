package com.xiaoxiya.wlmalldemocommon.spitest;

/**
 * @author luopeng
 * @date 2019/8/13 11:36
 */
public class WhitePigServiceImpl implements IpigService {
    @Override
    public void sleep() {
        System.out.println("白色的猪在睡觉。。。。。");
    }
}
