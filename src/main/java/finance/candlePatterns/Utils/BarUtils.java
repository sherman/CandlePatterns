package finance.candlePatterns.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import finance.candlePatterns.Core.Bar;

public class BarUtils {
    private BarUtils() {}
    
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
    
    public static int getLastBarOfTheDay(List<Bar> bars, Bar bar) {
        int index = bars.indexOf(bar);
        while (
            index < bars.size() - 1
            &&
                bars.get(index + 1).time.dayOfMonth().
                equals(bar.time.dayOfMonth())
        ) {
            index++;
        }
        
        return index;
    }
    
    public static List<Bar> getBarsForWholeDay(
        List<Bar> bars,
        Bar bar,
        List<Integer> ignoreHours
    ) {
        int beginIndex = BarUtils.getFirstBarOfTheDay(bars, bar);
        int endIndex = BarUtils.getLastBarOfTheDay(bars, bar);
        
        List<Bar> dayBars = new ArrayList<Bar>();
        
        for (int i = beginIndex; i <= endIndex; i++) {
            if (ignoreHours.contains(bars.get(i).time.getHourOfDay()))
                continue;
            
            dayBars.add(bars.get(i));
        }
        
        return dayBars;
    }
}
