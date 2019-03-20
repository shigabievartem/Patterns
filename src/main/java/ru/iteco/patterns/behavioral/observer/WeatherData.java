package ru.iteco.patterns.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Observable {
    private float temperature;
    private float humidity;
    private int pressure;
    Set<Observer> observerList = new HashSet<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    void setNewWeather(float temperature, float humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
