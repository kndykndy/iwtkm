package some.company.model;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = {"timestampMillis"})
public class StatisticsEntity {

    private long timestampMillis;
    private BigDecimal sum = BigDecimal.ZERO;
    private BigDecimal max;
    private BigDecimal min;
    private long count;

    public BigDecimal getMin() {
        return (min != null) ? min : BigDecimal.ZERO;
    }

    public BigDecimal getMax() {
        return (max != null) ? max : BigDecimal.ZERO;
    }

    public BigDecimal getAverage() {
        return (count != 0)
            ? BigDecimal.valueOf(sum.doubleValue() / count)
            : BigDecimal.ZERO;
    }

    public void add(BigDecimal value) {
        if (value == null) {
            return;
        }

        sum = sum.add(value);
        min = (min != null) ? min.min(value) : value;
        max = (max != null) ? max.max(value) : value;
        count++;
    }

    public void add(StatisticsEntity entity) {
        if (entity == null) {
            return;
        }

        sum = sum.add(entity.getSum());
        min = (min != null) ? min.min(entity.getMin()) : entity.getMin();
        max = (max != null) ? max.max(entity.getMax()) : entity.getMax();
        count += entity.getCount();
    }

    @Setter
    @Getter
    public static class Dto {

        private String sum;
        private String avg;
        private String max;
        private String min;
        private long count;

    }

}
