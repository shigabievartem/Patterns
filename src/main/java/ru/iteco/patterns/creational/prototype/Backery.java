package ru.iteco.patterns.creational.prototype;

public class Backery {
    private volatile Bread bread;

    public Backery(Bread bread) {
        this.bread = bread;
    }

    public Bread cookBread() throws CloneNotSupportedException {
        return this.bread.clone();
    }
}
