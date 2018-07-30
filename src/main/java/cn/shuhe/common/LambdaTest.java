package cn.shuhe.common;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: wuwenshuai
 * @Date: 2018/7/27 17:31
 * @Description:
 */
public class LambdaTest {
    /**
     * lambda表达式的构成{
     *     左边：lambda表达式的参数列表
     *     右边:lambda表达式需要执行的功能，即lambda体
     * }
     */

    @Test
    //无参数，无返回值
    public void test1(){


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------");
            }
        });
        thread.start();


        //利用lambda表达式去实现
        Thread thread1 = new Thread(()-> System.out.println("================"));
        thread1.start();
    }
}
