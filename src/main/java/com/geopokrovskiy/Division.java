package com.geopokrovskiy;

public class Division extends Operation {

    public Division(){
        this.priority = 2;
    }

    @Override
    public double operation(double a, double b) {
        return a / b;
    }

    @Override
    public Operation newInstance() {
        return new Division();
    }
}
