package ru.iteco.patterns.behavioral.observer;

public interface Observer {
    void update(float temperature, float humidity, int pressure);
}
