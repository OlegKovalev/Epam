package se07.task3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerSetterGetter extends Thread {

    private static Lock lock = new ReentrantLock();
    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersFromResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    private void setIntegersFromResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        resource.setElement(number);
        System.out.println("Поток " + getName() + " записал число "
                + number);
    }

    public void getIntegersFromResource() throws InterruptedException {
        Integer number;

        lock.lock();

        System.out.println("Поток " + getName() + " хочет извлечь число.");
        number = resource.getElement();
        if (number == null) {
            System.out.println("Поток " + getName() + " ждёт пока очередь заполнится.");
            System.out.println("Поток " + getName() + " возобновил работу.");
            number = resource.getElement();
        }
        System.out.println("Поток " + getName() + " извлёк число " + number);

        lock.unlock();
    }
}







