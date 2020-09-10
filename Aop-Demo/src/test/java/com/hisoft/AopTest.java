package com.hisoft;

import com.hisoft.pojo.Provider;
import com.hisoft.pojo.User;
import com.hisoft.service.provider.ProviderService;
import com.hisoft.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public  void test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =(UserService) context.getBean("userService");
        userService.saveUser(new User());
    }
    @Test
    public  void test1(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        ProviderService providerService =(ProviderService) context.getBean("providerservice");
        providerService.add(new Provider());
    }
}
