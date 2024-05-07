package com.williams.service;

import com.spring.annotation.Component;
import com.spring.core.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * 每个 BeanPostProcessor 是针对所有 Bean 的
 *
 * @author Williams
 */
@Component
public class ValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        System.out.println("初始化前..");
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(WilliamsValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, field.getAnnotation(WilliamsValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // bean
        return bean;
    }
}
