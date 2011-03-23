package finance.candlePatterns.Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finance.candlePatterns.Utils.Pair;

public class Analyzer {
    private final Map<String, List<Integer>> statistic;
    
    // total
    private final Pair<Double, Double> result;
    
    private final Map<String, Pair<Double, Double>> perMonthResult =
        new HashMap<String, Pair<Double, Double>>();
    
    public Analyzer(Map<String, List<Integer>> statistic) {
        this.statistic = statistic;
        
        int successCnt = 0, failCnt = 0;
        
        int total = 0;
        
        for (String key : this.statistic.keySet()) {
            int perMonthSuccessCnt = 0, perMonthFailCnt = 0;
            int perMonthTotal = 0;
            
            for (int i : this.statistic.get(key)) {
                if (i == 1) {
                    successCnt++;
                    perMonthSuccessCnt++;
                } else {
                    failCnt++;
                    perMonthFailCnt++;
                }
                
                total++;
                perMonthTotal++;
            }
            
            perMonthResult.put(
                key,
                new Pair<Double, Double>(
                    (double)perMonthSuccessCnt / perMonthTotal * 100,
                    (double)perMonthFailCnt / perMonthTotal * 100
                )
            );
        }
        
        result = new Pair<Double, Double>(
            (double)successCnt / total * 100,
            (double)failCnt / total * 100
        );
    }

    public double getSuccess() {
        return result.first;
    }

    public double getFail() {
        return result.second;
    }
    
    public double getSuccess(String key) {
        return perMonthResult.get(key).first;
    }
    
    public double getFail(String key) {
        return perMonthResult.get(key).second;
    }
}
