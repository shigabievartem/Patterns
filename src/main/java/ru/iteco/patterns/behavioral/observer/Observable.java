package ru.iteco.patterns.behavioral.observer;

public interface Observable {
    void registerObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers();
}
