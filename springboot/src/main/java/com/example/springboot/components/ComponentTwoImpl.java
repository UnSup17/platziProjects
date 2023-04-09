package com.example.springboot.components;

import org.springframework.stereotype.Component;

import com.example.springboot.components.interfaces.IComponent;

@Component
public class ComponentTwoImpl implements IComponent {

    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi componente dos");
    }

}
