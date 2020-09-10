package com.hisoft.dao.user;

import com.hisoft.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user) {
        System.out.println("方法执行成功");
        return 1;
    }
}
