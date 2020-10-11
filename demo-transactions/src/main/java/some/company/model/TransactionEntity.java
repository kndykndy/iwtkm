package some.company.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TransactionEntity {

    private BigDecimal amount;
    private long timestampMillis;

    @Setter
    @Getter
    @ToString
    public static class Dto {

        private String amount;
        private String timestamp;

    }

}
