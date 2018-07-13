package cn.shuhe.controller;

import cn.shuhe.common.Result;
import cn.shuhe.domain.User;
import cn.shuhe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    //查询所有用户
   /* @RequestMapping("/userList")
    public List<User> selectUserList(){
        List<User> userList = userService.selectUserList();
        return userList;
    }

    //删除用户
    @RequestMapping(value = "/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new Result(true,"ok");
    }

    //注册用户
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody User user){
        System.out.println("-------------------------");
        System.out.println(user.getUserName()+"----------------------");

        Result result = userService.register(user.getUserName(), user.getUserPassword());
        return result;

    }

    //用户登陆

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpSession session){
        User userLogin = userService.login(user);
        if(userLogin==null){
            return new Result(false,"登陆失败,用户名或者密码错误");
        }
        //把登陆用户放到session中去
        session.setAttribute("LoginUser",userLogin);
        return new Result(true,"登陆成功");
    }*/


   //测试

    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public List<User> selectUserList(){
        List<User> userList = userService.selectUserListByGen();
        return userList;
    }


    //用户登陆

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpSession session){
        Result result = userService.login(user);
        //把登陆用户放到session中去
        session.setAttribute("LoginUser",user);
        return result;
    }


    //注册用户
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody User user){
        Result result = userService.register(user.getUserName(), user.getUserPassword());
        return result;
    }




}
