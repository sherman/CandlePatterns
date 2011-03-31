package finance.candlePatterns.Utils;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import finance.candlePatterns.Core.Bar;

public class BarUtils {
    private BarUtils() {}
    
    public static boolean isUpTrend(Map<LocalDate, List<Bar>> bars, Bar bar) {
        final List<Bar> dayBars = bars.get(bar.time.toLocalDate());
        
        return
            dayBars.get(dayBars.size() - 1).close.
                subtract(dayBars.get(0).open).
                    doubleValue() > 0;
    }
    
    public static int getFirstBarOfTheDay(List<Bar> bars, Bar bar) {
        int index = bars.indexOf(bar);
        while (
            index > 0
            &&
                bars.get(index - 1).time.dayOfMonth().
                equals(bar.time.dayOfMonth())
        ) {
            index--;
        }
        
        return index;
    }
}
