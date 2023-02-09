package com.geopokrovskiy;

public abstract class Operation {
    protected int priority;

    public abstract double operation(double a, double b);

    public int getPriority(){
        return this.priority;
    }

    public abstract Operation newInstance();
}
