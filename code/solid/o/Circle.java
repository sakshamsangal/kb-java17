package com.app.solid.o;

class Circle implements Shape {
    public Double radius;

    @Override
    public void calculate() {
        System.out.println(radius * radius * 3.14);
    }
}