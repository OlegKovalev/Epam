package se07.task1;

import java.util.List;

public class Executor {

    private DocumentReader documentReader;

    public Executor(String filePath) {
        this.documentReader = new DocumentReader(filePath);
    }

    public void executeTransaction(AccountStore accountStore, int threadCount) {
        List<String> transactions = documentReader.readDocument();
        if (threadCount == 0) {
            throw new IllegalArgumentException("Wrong number of thread!");
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                int start = i * transactions.size() / threadCount;
                int end = (i + 1) * transactions.size() / threadCount;

                TransactionExecutor transactionExecutor = new TransactionExecutor("N" + i, accountStore, transactions.subList(start, end));

                transactionExecutor.start();
                transactionExecutor.join();
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
