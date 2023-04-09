package com.example.springboot.bean;

import com.example.springboot.bean.interfaces.IBean;

public class BeanImpl implements IBean {
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia del bean");
    }
}
