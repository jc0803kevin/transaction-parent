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
 * @Date Created on 2020/5/25 14:03
 */

@Slf4j
@Service
public class UserService2Impl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        userMapper.insert(user);

        // 事务不会生效
        //this.save2(user);

        // 新的事务生效
        ((UserService2Impl) AopContext.currentProxy()).save2(user);
        //异常
        int a = 10/0;
    }

    /**
     * @Author kevin
     * @Description 开启一个新的事务
     * @Date Created on 2020/5/25 15:17
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(User user) {
        user.setName("save2-"+user.getName());
        userMapper.insert(user);
    }

}
