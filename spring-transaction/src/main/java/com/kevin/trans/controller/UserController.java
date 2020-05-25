package com.kevin.trans.controller;

import com.kevin.trans.entity.User;
import com.kevin.trans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kevin
 * @Description
 * @Date Created on 2020/5/25 14:05
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String add(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);

        userService.save(user);
        return System.currentTimeMillis()+"";
    }

}
