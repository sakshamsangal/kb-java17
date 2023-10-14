package com.app.solid.o;

class Rectangle implements Shape {
    public Double height;
    public Double width;

    @Override
    public void calculate() {
        System.out.println(height * width);
    }
}