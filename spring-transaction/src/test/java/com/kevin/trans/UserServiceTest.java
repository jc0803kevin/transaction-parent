package com.kevin.trans;

import com.kevin.trans.entity.User;
import com.kevin.trans.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author kevin
 * @Description
 * @Date Created on 2020/5/25 15:12
 */
public class UserServiceTest extends BaseTest {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setName("kevin");

        userService.save(user);

    }


}
