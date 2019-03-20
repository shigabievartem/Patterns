package ru.iteco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.iteco.patterns.creational.factory.FactoryMethod;
import ru.iteco.patterns.creational.factory.objects.AUDI;
import ru.iteco.patterns.creational.factory.objects.BMW;
import ru.iteco.patterns.creational.prototype.Backery;
import ru.iteco.patterns.creational.prototype.Bread;
import ru.iteco.patterns.creational.singleton.SingletonPattern;
import ru.iteco.patterns.structural.adapter.RoundHole;
import ru.iteco.patterns.structural.adapter.RoundPeg;
import ru.iteco.patterns.structural.adapter.SquadPeg;
import ru.iteco.patterns.structural.adapter.SquadPegAdapter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pattern {
    private final int threadsCount = 15;
    private final int taskCount = 10000;
    private final Set<Object> set = Collections.synchronizedSet(new HashSet<>());

    @Before
    public void prepareTest() {
        set.clear();
    }

    @Test
    public void singletonTest() {
        pushInDifferentThreads(() -> {
            set.add(SingletonPattern.getInstance());
        });
        Assert.assertEquals(1, set.size());
    }

    @Test(expected = RuntimeException.class)
    public void factoryMethod() {
        Assert.assertEquals("BMW", FactoryMethod.getCar(BMW.class).getBrand());
        Assert.assertEquals("AUDI", FactoryMethod.getCar(AUDI.class).getBrand());
        // Ожидаем RuntimeException и до последней строчки дойти не должны
        FactoryMethod.getCar(Object.class);
        Assert.fail();
    }

    @Test
    public void prototype() {
        pushInDifferentThreads(() -> {
            try {
                set.add(new Backery(new Bread("Нарезной")).cookBread());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Assert.assertEquals(taskCount, set.size());

    }

    @Test
    public void testAdapter() {
        RoundHole hole = new RoundHole(5);
        RoundPeg smallRoundPeg = new RoundPeg(3);
        RoundPeg bigRoundPeg = new RoundPeg(7);
        SquadPeg smallSquadPeg = new SquadPeg(2);
        SquadPeg bigSquadPeg = new SquadPeg(10);

        Assert.assertTrue(hole.fits(smallRoundPeg));
        Assert.assertFalse(hole.fits(bigRoundPeg));
        Assert.assertTrue(hole.fits(new SquadPegAdapter(smallSquadPeg)));
        Assert.assertFalse(hole.fits(new SquadPegAdapter(bigSquadPeg)));
    }

    private void pushInDifferentThreads(Runnable action) {
        ExecutorService pool = Executors.newFixedThreadPool(threadsCount);
        CountDownLatch latch = new CountDownLatch(taskCount);
        try {
            for (int i = taskCount; i > 0; i--) {
                try {
                    pool.submit(action).get();
                } finally {
                    latch.countDown();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            pool.shutdownNow();
        }
    }
}
