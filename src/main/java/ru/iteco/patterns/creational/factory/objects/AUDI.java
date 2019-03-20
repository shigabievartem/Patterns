package ru.iteco.patterns.creational.factory.objects;

public class AUDI extends AbstractCar {
    public AUDI() {
        super("AUDI", "6");
    }

    @Override
    public void ride() {
        System.out.println("i'm riding on " + this.getBrand() + " " + this.getModel());
    }
}
