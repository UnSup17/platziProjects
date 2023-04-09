package com.example.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.bean.Bean2Impl;
import com.example.springboot.bean.BeanWithDependencyImpl;
import com.example.springboot.bean.OperationImpl;
import com.example.springboot.bean.interfaces.IBean;
import com.example.springboot.bean.interfaces.IBeanWithDependency;
import com.example.springboot.bean.interfaces.IOperation;

@Configuration
public class ConfigurationBean {
    @Bean
    public IBean beanOperation() {
        return new Bean2Impl();
    }

    @Bean
    public IOperation beanOperationOperation() {
        return new OperationImpl();
    }

    @Bean
    public IBeanWithDependency beanOperationBeanWithDependency(IOperation operation) {
        return new BeanWithDependencyImpl(operation);
    }
}
