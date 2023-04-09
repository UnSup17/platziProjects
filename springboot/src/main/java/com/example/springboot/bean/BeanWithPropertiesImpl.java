package com.example.springboot.bean;

import com.example.springboot.bean.interfaces.IBeanWithProperties;

public class BeanWithPropertiesImpl implements IBeanWithProperties {

    private String name;
    private String apellido;

    public BeanWithPropertiesImpl(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return name + "-" + apellido;
    }

}
