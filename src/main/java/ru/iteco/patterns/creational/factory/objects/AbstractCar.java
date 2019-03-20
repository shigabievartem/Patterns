package ru.iteco.patterns.creational.factory.objects;

public abstract class AbstractCar {
    private final String brand;
    private final String model;

    protected AbstractCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public abstract void ride();
}
