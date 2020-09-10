package com.hisoft.service.user;

import com.hisoft.dao.user.UserDao;
import com.hisoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
   /* @Autowired
    @Qualifier("userDao")*/
   @Resource(name = "userDao")
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer saveUser(User user) {
//        int a =1/0;
        return userDao.add(user);
    }
}
