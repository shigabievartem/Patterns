package ru.iteco.patterns.creational.singleton;

public class SingletonPattern {

    private static volatile SingletonPattern instance;

    public static SingletonPattern getInstance() {

        SingletonPattern localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonPattern.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonPattern();
                }
            }
        }
        return localInstance;
    }
}
