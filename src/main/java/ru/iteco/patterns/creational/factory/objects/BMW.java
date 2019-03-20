package ru.iteco.patterns.creational.factory.objects;

public class BMW extends AbstractCar {

    public BMW() {
        super("BMW", "5");
    }

    @Override
    public void ride() {
        System.out.println("i'm riding on " + this.getBrand() + " " + this.getModel());
    }
}
