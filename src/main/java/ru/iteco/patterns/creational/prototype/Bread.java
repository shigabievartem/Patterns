package ru.iteco.patterns.creational.prototype;

import java.util.Calendar;

public class Bread implements Cloneable {
    private final Calendar date;
    private final String breadType;

    public Bread(String breadType) {
        this.breadType = breadType;
        this.date = Calendar.getInstance();
    }

    public Calendar getDate() {
        return date;
    }

    public String getBreadType() {
        return breadType;
    }

    @Override
    public Bread clone() throws CloneNotSupportedException {
        return (Bread) super.clone();
    }
}
