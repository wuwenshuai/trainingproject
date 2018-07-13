package cn.shuhe.controller;

import cn.shuhe.domain.User;
import cn.shuhe.domain.UserExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/test")
    public String getIndex(){
        return "test";
    }
}
