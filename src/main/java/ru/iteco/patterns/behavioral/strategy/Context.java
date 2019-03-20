package ru.iteco.patterns.behavioral.strategy;

/**
 * Класс, который рулит стратегией
 */
public class Context {
    private Strategy strategy = new DefenciveStrategy();

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeAction() {
        strategy.action();
    }

    public static void main(String[] args) {
        Context context = new Context();

        context.executeAction();
        context.setStrategy(new AttackStrategy());
        context.executeAction();
    }
}
