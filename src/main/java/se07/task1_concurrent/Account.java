package se07.task1_concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private AtomicInteger balance;
    private int id;

    public Account(int balance, int id) {
        this.id = id;
        this.balance = new AtomicInteger(balance);
    }

    public int getBalance() {
        return balance.get();
    }

    public int getId() {
        return id;
    }

    public void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public void withdraw(int amount) {
        balance.addAndGet(-amount);
    }
}
