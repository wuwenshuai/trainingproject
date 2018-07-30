package cn.shuhe.common;

import org.junit.jupiter.api.Test;

/**
 * @Auther: wuwenshuai
 * @Date: 2018/7/27 16:04
 * @Description:
 */
public class TestEnumDemo {

    @Test
    public void test(){
        TestEnum[] values = TestEnum.values();

        for (TestEnum testEnum : values){
            System.out.println(testEnum);
        }

    }
}
