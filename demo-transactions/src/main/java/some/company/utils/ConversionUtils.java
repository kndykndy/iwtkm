package some.company.utils;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import some.company.exceptions.impl.FieldsNotParsableException;
import some.company.model.StatisticsEntity;
import some.company.model.TransactionEntity;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversionUtils {

    public static StatisticsEntity.Dto convertStatisticsEntityToDto(
        StatisticsEntity statisticsEntity) {

        final StatisticsEntity.Dto result = new StatisticsEntity.Dto();
        result.setSum(convertBigDecimalToString(statisticsEntity.getSum()));
        result.setAvg(convertBigDecimalToString(statisticsEntity.getAverage()));
        result.setMax(convertBigDecimalToString(statisticsEntity.getMax()));
        result.setMin(convertBigDecimalToString(statisticsEntity.getMin()));
        result.setCount(statisticsEntity.getCount());

        return result;
    }

    public static TransactionEntity convertTransactionEntityDtoToEntity(
        TransactionEntity.Dto transactionEntityDto) {

        final TransactionEntity result = new TransactionEntity();

        final String tmpAmount = transactionEntityDto.getAmount();
        try {
            if (Strings.isNullOrEmpty(tmpAmount)) {
                throw new NumberFormatException();
            }

            result.setAmount(new BigDecimal(tmpAmount));
        } catch (NumberFormatException nfe) {
            log.error("Cannot parse transaction amount: {}", transactionEntityDto);
            log.error("", nfe);

            throw new FieldsNotParsableException();
        }

        final String tmpTimestamp = transactionEntityDto.getTimestamp();
        try {
            if (Strings.isNullOrEmpty(tmpTimestamp)) {
                throw new DateTimeException("");
            }

            result.setTimestampMillis(Instant.parse(tmpTimestamp).toEpochMilli());
        } catch (DateTimeException dte) {
            log.error("Cannot parse transaction timestamp: {}", transactionEntityDto);
            log.error("", dte);

            throw new FieldsNotParsableException();
        }

        return result;
    }

    private static String convertBigDecimalToString(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

}
