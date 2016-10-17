package se07.task1_concurrent;

import java.util.List;

public class TransactionExecutor extends Thread {

    private AccountStore accountStore;
    private List<String> transactions;

    public TransactionExecutor(String name, AccountStore accountStore, List<String> transactions) {
        super(name);
        this.accountStore = accountStore;
        this.transactions = transactions;
    }

    public void run() {
        for (String transaction : transactions) {
            String[] tokens = transaction.split(" ");
            if (tokens.length == 3) {
                accountStore.withdraw(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2]));
                accountStore.deposit(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }
        }
    }
}
