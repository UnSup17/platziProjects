package com.example.springboot.bean;

import com.example.springboot.bean.interfaces.IBean;

public class Bean2Impl implements IBean {
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia del bean dos");
    }
}
