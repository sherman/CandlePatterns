package finance.candlePatterns.Core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FilterApplier {
    private final Logger log = Logger.getLogger(FilterApplier.class);
    private final BarFilter filter;
    
    public FilterApplier(BarFilter filter) {
        this.filter = filter;
    }
    
    public void filtrate(List<Bar> bars) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (Bar current : bars) {
            if (filter.isAppliedFor(current)) {
                if (filter.isSuccess(current)) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        
        Analyzer analyzer = new Analyzer(result);
        System.out.println("Success:" + analyzer.getSuccess());
        System.out.println("Fail:" + analyzer.getFail());
    }
}
