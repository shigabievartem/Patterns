package ru.iteco.patterns.structural.proxy;

public class MathObjProxy implements SimpleMath {
    MathObj math;

    @Override
    public double sum(double a, double b) {
        if (math == null) math = new MathObj();
        return math.sum(a,b);
    }

    @Override
    public double dif(double a, double b) {
        if (math == null) math = new MathObj();
        return math.dif(a,b);
    }

    @Override
    public double mul(double a, double b) {
        if (math == null) math = new MathObj();
        return math.mul(a,b);
    }

    @Override
    public double div(double a, double b) {
        if (math == null) math = new MathObj();
        return math.div(a,b);
    }

    public static void main(String[] args) {
        double a = 4d;
        double b = 2d;
        SimpleMath math123 = new MathObjProxy();
        // Do the math
        System.out.println("4 + 2 = " + math123.sum(a,b));
        System.out.println("4 - 2 = " + math123.dif(a,b));
        System.out.println("4 * 2 = " + math123.mul(a,b));
        System.out.println("4 / 2 = " + math123.div(a,b));
    }
}
