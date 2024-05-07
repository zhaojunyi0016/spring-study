package com.williams.service;

import com.spring.annotation.Component;
import com.spring.core.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP 功能  基于 BeanPostProcessor 的 postProcessAfterInitialization方法实现
 *
 * @author Williams
 */
@Component
public class AopBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(AopBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 切面
                    System.out.println("初始化后...切面逻辑");

                    return method.invoke(bean, args);
                }
            });

            // 返回代理对象
            return proxyInstance;
        }

        // bean
        return bean;
    }
}
