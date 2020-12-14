package com.qianxia.tourism.controller;

import com.qianxia.tourism.common.Msg;
import com.qianxia.tourism.domain.User;
import com.qianxia.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/logup")
    public String logup(){
        return "redirect:/";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/login/verifyLogin")
    public @ResponseBody Msg login(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   HttpSession session){
        User user = userService.queryUserByTerms(username,password);

        if (null != user){
            List<User> list = new ArrayList<>();
            list.add(user);
            session.setAttribute("user",user);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查找是否存在重复的username
     * @param username
     * @return
     */
    @GetMapping("/login/verifyUsername/{username}")
    public @ResponseBody Msg verifyUsername(@PathVariable("username") String username){

        User user = userService.queryUserByUsername(username);
        if(null != user){
            return Msg.success();
        }

        return Msg.fail();
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/login/register")
    public @ResponseBody Msg verifyRegister(User user){
        user.setStatus(1);
        int count = userService.insert(user);
        if (count != 1){
            return Msg.fail();
        }
        return Msg.success().add("url","/");
    }
}
