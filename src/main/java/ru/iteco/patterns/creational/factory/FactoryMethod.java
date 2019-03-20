package ru.iteco.patterns.creational.factory;

import ru.iteco.patterns.creational.factory.objects.AUDI;
import ru.iteco.patterns.creational.factory.objects.AbstractCar;
import ru.iteco.patterns.creational.factory.objects.BMW;

public class FactoryMethod {
    public static synchronized AbstractCar getCar(Class clazz) {
        if (clazz == BMW.class) return new BMW();
        if (clazz == AUDI.class) return new AUDI();
        throw new RuntimeException("Unknown car");
    }
}
