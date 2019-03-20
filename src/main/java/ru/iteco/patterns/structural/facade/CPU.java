package ru.iteco.patterns.structural.facade;

public class CPU {
    public void freeze() {
        System.out.println("CPU freeze");
    }

    public void jump(long position) {
        System.out.println("CPU jump to " + position + " position");
    }

    public void execute() {
        System.out.println("CPU execute something");
    }
}
