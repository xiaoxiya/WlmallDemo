package com.xiaoxiya.wlmalldemocommon.spitest;

import java.util.ServiceLoader;

/**
 * @author luopeng
 * @date 2019/8/13 11:33
 * SPI（service  provider interface）机制的约定：
    1、在META-INF/services/目录中创建以接口全限定名命名的文件该文件的内容可以有多行，每行都是该接口对应的具体实现类的全限定名.
    2、使用ServiceLoader类动态加载META-INF中的实现类
    3、如SPI的实现类为Jar则需要放在主程序classPath中
    4、Api具体实现类必须有一个不带参数的构造方法
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IpigService> loader = ServiceLoader.load(IpigService.class);
        for (IpigService d : loader) {
            d.sleep();
        }
    }
}
