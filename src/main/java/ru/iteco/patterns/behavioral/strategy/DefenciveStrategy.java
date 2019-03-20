package ru.iteco.patterns.behavioral.strategy;

public class DefenciveStrategy implements Strategy {
    @Override
    public void action() {
        System.out.println("Hold this positions!");
    }
}
