package com.williams;

import com.spring.core.ApplicationContext;
import com.williams.service.UserInterface;

/**
 * @author Williams
 */
public class Test {

    public static void main(String[] args) {

        // 扫描--->创建单例Bean BeanDefinition BeanPostPRocess
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);

        UserInterface userService = (UserInterface) applicationContext.getBean("userService");
        userService.test();
    }
}
