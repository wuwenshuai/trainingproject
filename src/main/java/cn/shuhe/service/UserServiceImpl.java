package cn.shuhe.service;

import cn.shuhe.common.Result;
import cn.shuhe.domain.User;
import cn.shuhe.domain.UserExample;
import cn.shuhe.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public Result register(String userName, String passWord) {
        User user = new User();
        user.setUserName(userName);
        //创建时间
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());


        //判断输入的参数是否合法
        //1 判断用户名是否为空
        if (StringUtils.isBlank(userName)){
            return new Result(false,"用户名不能为空");
        }
        //2判断密码是否为空
        if (StringUtils.isBlank(passWord)){
            return new Result(false,"，密码不能为空");
        }
        //md5加密
        String md5password = DigestUtils.md5DigestAsHex(passWord.getBytes());
        user.setUserPassword(md5password);

        int i = userMapper.insert(user);
        if (i<0){
            throw new RuntimeException("注册失败");
        }
        return new Result(true,"注册成功");
    }

    @Override
    public Result login(User user) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        //查询用户信息
        List<User> users = userMapper.selectByExample(example);
        if(users==null || users.size()<=0){
            //用户名或者密码错误
            return new Result(false,"用户名错误");
        }
        //  用户名正确判断密码是否正确
        //把密码加密
        String userPassword = user.getUserPassword();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        User userLogin = users.get(0);
        if (!userLogin.getUserPassword().equals(md5DigestAsHex)){
            return new Result(false,"密码错误");
        }
        return new Result(true,"登陆成功");
    }

    @Override
    public List<User> selectUserListByGen() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }


    /*@Autowired
    private UserMapper1 userMapper;

    @Override
    public List<User> selectUserList() {
        List<User> userList = userMapper.selectUserList();
        return userList;
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public Result register(String userName, String userPassword) {

        User user = new User();
        user.setUserName(userName);
        //创建时间
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        //md5加密
        String md5password = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        user.setUserPassword(md5password);

        int i = userMapper.register(user);
        if (i<0){
            throw new RuntimeException("注册失败");
        }
        return new Result(true,"注册成功");
    }

    @Override
    public User login(User user) {
        //把密码加密
        String userPassword = user.getUserPassword();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        user.setUserPassword(md5DigestAsHex);
        User userLogin = userMapper.login(user);
        return userLogin;
    }
    */



}
