package com.example.springboot.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.springboot.bean.interfaces.IBeanWithDependency;
import com.example.springboot.bean.interfaces.IOperation;

public class BeanWithDependencyImpl implements IBeanWithDependency {

    private Log LOGGER = LogFactory.getLog(this.getClass());

    private IOperation operation;

    public BeanWithDependencyImpl(IOperation operation) {
        this.operation = operation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Estamos en printWithDependency");
        System.out.println(operation.sum(3, 6));
        LOGGER.debug("Se enviaron 2 y 3" + operation.sum(3, 6));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }

}
