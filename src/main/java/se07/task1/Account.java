package se07.task1;

public class Account {

    private int balance;
    private int id;

    public Account(int balance, int id) {
        this.balance = balance;
        this.id = id;
    }
    
    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public synchronized void deposit(int amount) {
        balance -= amount;
    }
    
    public synchronized void withdraw(int amount) {
        balance += amount;
    }
}
