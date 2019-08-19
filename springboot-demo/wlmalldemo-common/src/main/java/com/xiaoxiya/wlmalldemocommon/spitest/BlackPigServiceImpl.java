package com.xiaoxiya.wlmalldemocommon.spitest;

/**
 * @author luopeng
 * @date 2019/8/13 11:35
 */
public class BlackPigServiceImpl implements IpigService {
    @Override
    public void sleep() {
        System.out.println("黑色的猪在睡觉");
    }
}
