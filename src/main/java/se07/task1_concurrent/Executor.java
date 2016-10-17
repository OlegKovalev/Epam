package se07.task1_concurrent;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    private DocumentReader documentReader;
    private List<TransactionExecutor> threadList;

    public Executor(String filePath) {
        this.documentReader = new DocumentReader(filePath);
    }

    public void executeTransaction(AccountStore accountStore, int threadCount) {
        List<String> transactions = documentReader.readDocument();
        threadList = new ArrayList<>();

        if (threadCount == 0) {
            throw new IllegalArgumentException("Wrong number of thread!");
        }

        for (int i = 0; i < threadCount; i++) {
            int start = i * transactions.size() / threadCount;
            int end = (i + 1) * transactions.size() / threadCount;

            TransactionExecutor transactionExecutor = new TransactionExecutor("N" + i, accountStore, transactions.subList(start, end));

            transactionExecutor.start();
            threadList.add(transactionExecutor);
        }

        for (TransactionExecutor transactionExecutor : threadList) {
            try {
                transactionExecutor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
