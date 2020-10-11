package some.company.service;

import some.company.model.StatisticsEntity;
import some.company.model.TransactionEntity;

public interface TransactionsService {

    void processTransaction(TransactionEntity transactionEntity);

    void deleteAllTransactions();

    StatisticsEntity getStatistics();

}
