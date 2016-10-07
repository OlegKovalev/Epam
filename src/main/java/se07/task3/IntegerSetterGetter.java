package se07.task3;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
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
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }

    public void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getElement();
            while (number == null) {
                System.out.println("Поток " + getName() + " ждёт пока очередь заполнится.");
                resource.wait();
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            System.out.println("Поток " + getName() + " извлёк число " + number);
        }
    }
}
