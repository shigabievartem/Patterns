package ru.iteco.patterns.structural.facade;

/**
 * Это и есть нащ фасад, который включает в себя логику
 */
public class Compucter {
    private final CPU cpu;
    private final HardDrive hardDrive;
    private final Memory memory;

    public Compucter() {
        this.cpu = new CPU();
        this.hardDrive = new HardDrive();
        this.memory = new Memory();
    }

    public void startCompucterToPlayDoca2() {
        cpu.freeze();
        memory.load();
        hardDrive.readData();
        cpu.jump(123l);
        cpu.execute();
    }

    // Для пользователя у нас будет всё вообще просто, просто нажал кнопку и рубись в доку
    public static void main(String[] args) {
        new Compucter().startCompucterToPlayDoca2();
    }
}
