package se07.task1_concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExecutorTest {

    static final String PATH = "E:\\GitHub\\Epam\\src\\main\\resources\\se07\\task1_synchronized\\Transactions";
    static final int THREAD_COUNT = 4;

    Executor executor;
    AccountStore accountStore;
    List<Account> accountList;

    @Before
    public void setUp() throws Exception {
        executor = new Executor(PATH);
        accountList = new ArrayList<>();

        accountList.add(new Account(5000, 1111));
        accountList.add(new Account(5000, 2222));
        accountList.add(new Account(5000, 3333));

        assertEquals(3, accountList.size());
        accountStore = new AccountStore(accountList);
    }

    @Test
    public void executeTransaction() throws Exception {
        executor.executeTransaction(accountStore, THREAD_COUNT);
        assertEquals(6307, accountList.get(0).getBalance());
        assertEquals(3173, accountList.get(1).getBalance());
        assertEquals(5520, accountList.get(2).getBalance());
    }

}