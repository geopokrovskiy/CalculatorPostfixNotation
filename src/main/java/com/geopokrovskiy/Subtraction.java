package com.geopokrovskiy;

public class Subtraction extends Operation{

    Subtraction(){
        this.priority = 1;
    }

    @Override
    public double operation(double a, double b) {
        return a - b;
    }

    @Override
    public Operation newInstance() {
        return new Subtraction();
    }
}
