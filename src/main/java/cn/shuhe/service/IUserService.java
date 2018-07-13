package cn.shuhe.service;

import cn.shuhe.common.Result;
import cn.shuhe.domain.User;

import java.util.List;

public interface IUserService {

    List<User> selectUserList();
    //删除用户信息
    void deleteUserById(Integer id);
    //注册用户
    Result register(String userName,String passWord);

    //用户登陆
    Result login(User user);



    //测试逆向工程生成的代码
    List<User> selectUserListByGen();
}
