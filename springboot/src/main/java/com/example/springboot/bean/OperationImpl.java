package com.example.springboot.bean;

import com.example.springboot.bean.interfaces.IOperation;

public class OperationImpl implements IOperation {

    @Override
    public int sum(int op1, int op2) {
        return op1 + op2;
    }

}
