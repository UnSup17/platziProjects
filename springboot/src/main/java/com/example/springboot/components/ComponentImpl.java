package com.example.springboot.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.springboot.bean.interfaces.IBeanWithDependency;
import com.example.springboot.components.interfaces.IComponent;

@Component
@Primary
public class ComponentImpl implements IComponent {

    private IBeanWithDependency beanWithDependency;

    public ComponentImpl(IBeanWithDependency beanWithDependency) {
        this.beanWithDependency = beanWithDependency;
    }

    @Override
    public void saludar() {
        beanWithDependency.printWithDependency();
        System.out.println("Hola mundo desde mi componente");
    }

}
