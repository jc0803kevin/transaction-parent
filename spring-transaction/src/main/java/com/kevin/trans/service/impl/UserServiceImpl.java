package com.kevin.trans.service.impl;

import com.kevin.trans.entity.User;
import com.kevin.trans.mapper.UserMapper;
import com.kevin.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author kevin
 * @Description
 *
 * 结果：
 *      数据库不会插入记录
 *
 * @Date Created on 2020/5/25 14:03
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        userMapper.insert(user);

        this.save2(user);
        //((UserServiceImpl) AopContext.currentProxy()).save2(user);
        //异常
        //int a = 10/0;

        try {
            //int a = 10/0;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save2(User user) {
        user.setName("save2-"+user.getName());
        userMapper.insert(user);

        //int a = 10/0;
        try {
            int a = 10/0;
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
