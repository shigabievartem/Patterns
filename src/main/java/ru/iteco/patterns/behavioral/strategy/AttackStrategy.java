package ru.iteco.patterns.behavioral.strategy;

public class AttackStrategy implements Strategy {
    @Override
    public void action() {
        System.out.println("Move in attack!");
    }
}
