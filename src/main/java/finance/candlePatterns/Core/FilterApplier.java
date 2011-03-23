package finance.candlePatterns.Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import finance.candlePatterns.Utils.StatisticUtils;

public class FilterApplier {
    private final Logger log = Logger.getLogger(FilterApplier.class);
    private final BarFilter filter;
    
    public FilterApplier(BarFilter filter) {
        this.filter = filter;
    }
    
    public void filtrate(List<Bar> bars) {
        Map<String, List<Integer>> statistic = new HashMap<String, List<Integer>>();

        List<Integer> result = null;

        String statisticKey = null;

        for (Bar current : bars) {
            if (
                null == statisticKey
                || !statisticKey.equals(StatisticUtils.key(current))
            ) {
                statisticKey = StatisticUtils.key(current);
                result = new ArrayList<Integer>();
                statistic.put(statisticKey, result);
            } else {
                if (filter.isAppliedFor(current)) {
                    if (filter.isSuccess(current)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                }
            }
        }
        
        Analyzer analyzer = new Analyzer(statistic);
        log.info("Success:" + analyzer.getSuccess());
        log.info("Fail:" + analyzer.getFail());
        
        for (String key : statistic.keySet()) {
            log.info("Key:" + key);
            log.info("Success:" + analyzer.getSuccess(key));
            log.info("Fail:" + analyzer.getFail(key));
        }
    }
}
