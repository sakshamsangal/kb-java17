package com.app.solid.l;

public class LiskovSubstitution {

    public static void main(String[] args) {

        // can't fly
        Ostrich ostrich = new Ostrich();
        ostrich.greet();

        // can fly
        Sparrow sparrow = new Sparrow();
        sparrow.fly();
    }
}

class Bird {

    public void greet() {
        System.out.println("greeting...");
    }
}

class FlyingBird {
    public void fly() {
        System.out.println("flying...");
    }
}

class Sparrow extends FlyingBird {
}

class Ostrich extends Bird {

}