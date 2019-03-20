package ru.iteco.patterns.structural.adapter;

public class SquadPegAdapter extends RoundPeg {

    final SquadPeg squadPeg;

    public SquadPegAdapter(SquadPeg squadPeg) {
        this.squadPeg = squadPeg;
    }

    @Override
    public double getRadius() {
        double side = squadPeg.getWidth() / 2;
        return Math.sqrt(Math.pow(side,2) + Math.pow(side,2));
    }
}
