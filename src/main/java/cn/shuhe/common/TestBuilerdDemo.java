package cn.shuhe.common;

import cn.shuhe.domain.User;
import org.junit.jupiter.api.Test;

/**
 * @Auther: wuwenshuai
 * @Date: 2018/7/26 15:45
 * @Description:
 */
public class TestBuilerdDemo {

    @Test
    public void test(){
        UserInfo carry = UserInfo.builder().age(12).email("www@qq").name("carry").build();
        System.out.println(carry.getName());
        //UserInfo userInfo = ;
        System.out.println(getUserInfo());
    }

    public UserInfo getUserInfo(){
        return UserInfo.builder()
                .age(22)
                .email("qqq@.com")
                .name("carry").build();
    }
}
