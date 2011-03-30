package finance.candlePatterns;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import finance.candlePatterns.Core.Bar;
import finance.candlePatterns.Core.FilterApplier;
import finance.candlePatterns.Core.HourToDaysFilterApplier;
import finance.candlePatterns.Filters.ExtremumOfTheDayFilter;
import finance.candlePatterns.Filters.LongTradeDayOfTheWeek;
import finance.candlePatterns.Filters.LongVolatilityBreakoutFilter;
import finance.candlePatterns.IO.DataLoader;
import finance.candlePatterns.IO.FinamDataParser;
import finance.candlePatterns.IO.FinamParserFactory;
import finance.candlePatterns.IO.ParserFactory;

/**
 *
 */
public class App {
    public static void main( String[] args ) {
        ParserFactory<FinamDataParser> pFactory =
            new FinamParserFactory<FinamDataParser>();
        
        DataLoader<FinamDataParser> loader = new DataLoader<FinamDataParser>(
            new File(args[0]),
            pFactory
        );
        
        List<Bar> bars = loader.load();
        
        HourToDaysFilterApplier applier = new HourToDaysFilterApplier(
            //new LongVolatilityBreakoutFilter(bars, 0.4)
            //new LongTradeDayOfTheWeek(bars, 3)
            new ExtremumOfTheDayFilter(bars, 11, Arrays.asList(10))
        );
        
        applier.filtrate(bars);
    }
}
