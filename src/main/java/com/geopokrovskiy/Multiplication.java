package com.geopokrovskiy;

public class Multiplication extends Operation {

    public Multiplication(){
        this.priority = 2;
    }

    @Override
    public double operation(double a, double b) {
        return a * b;
    }

    @Override
    public Operation newInstance() {
        return new Multiplication();
    }
}
