package finance.candlePatterns.Utils;

import finance.candlePatterns.Core.Bar;

public class StatisticUtils {
    private StatisticUtils() {}
    
    public static String key(Bar bar) {
        return bar.time.getYear() + "_" + bar.time.getMonthOfYear();
    }
}
