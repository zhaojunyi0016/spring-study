package com.williams.service;

import com.spring.annotation.Autowired;
import com.spring.annotation.Component;
import com.spring.core.BeanNameAware;
import com.spring.core.InitializingBean;

/**
 * @author Williams
 */
@Component
public class UserService implements UserInterface, BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    @WilliamsValue("xxx")
    private String test;


    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println("字段 test =" + test);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化...调用 afterPropertiesSet");
    }
}
