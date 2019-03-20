package ru.iteco.patterns.structural.proxy;

public class MathObj implements SimpleMath {
    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double dif(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }
}
