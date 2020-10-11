package some.company.service.impl;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import some.company.exceptions.impl.OldTransactionException;
import some.company.exceptions.impl.TransactionInFutureException;
import some.company.model.StatisticsEntity;
import some.company.model.TransactionEntity;
import some.company.service.TransactionsService;

@Slf4j
@Service
public class TransactionsServiceImpl implements TransactionsService {

    private static final int MS_AMOUNT_PER_STATISTICS_INTERVAL = 60 * 1000;

    /**
     * Keeps Statistic entity for each millisecond in the interval for which statistics is being
     * gathered.
     */
    private static final Map<Integer, StatisticsEntity> transactionsMap =
        new ConcurrentHashMap<>(MS_AMOUNT_PER_STATISTICS_INTERVAL);


    @Override
    public void processTransaction(TransactionEntity transactionEntity) {
        final long currentMillis = Instant.now().toEpochMilli();

        long transactionTimestampMillis = transactionEntity.getTimestampMillis();
        if (transactionTimestampMillis > currentMillis) {
            log.error("Transaction in the future: {}", transactionEntity);

            throw new TransactionInFutureException();
        }

        final int offsetMillis = (int) (currentMillis - transactionTimestampMillis);
        if (offsetMillis > MS_AMOUNT_PER_STATISTICS_INTERVAL) {
            log.error("Transaction is outdated: {}", transactionEntity);

            throw new OldTransactionException();
        }

        transactionsMap.compute(
            offsetMillis,
            (millisecondForInterval, statisticsEntity) -> {
                if (statisticsEntity == null ||
                    statisticsEntity.getTimestampMillis() > transactionTimestampMillis) {
                    statisticsEntity = new StatisticsEntity();
                    statisticsEntity.setTimestampMillis(transactionTimestampMillis);
                }

                statisticsEntity.add(transactionEntity.getAmount());

                return statisticsEntity;
            });
    }

    @Override
    public void deleteAllTransactions() {
        transactionsMap.clear();
    }

    @Override
    public StatisticsEntity getStatistics() {
        final long currentMillis = Instant.now().toEpochMilli();

        final StatisticsEntity result = new StatisticsEntity();

        transactionsMap.values().stream()
            .filter(entity ->
                (currentMillis - entity.getTimestampMillis()) < MS_AMOUNT_PER_STATISTICS_INTERVAL)
            .forEach(result::add);

        return result;
    }

}
