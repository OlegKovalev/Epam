package se07.task1_synchronized;

import java.util.List;

public class AccountStore {

    private List<Account> accountList;

    public AccountStore(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void deposit(int id, int amount) {
        getAccountById(id).deposit(amount);
    }

    public void withdraw(int id, int amount) {
        getAccountById(id).withdraw(amount);
    }

    private Account getAccountById(int id) {
        for (Account account : accountList) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
