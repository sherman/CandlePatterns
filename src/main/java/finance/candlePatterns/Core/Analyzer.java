package finance.candlePatterns.Core;

import java.util.List;

public class Analyzer {
    private final List<Integer> result;
    private final double success;
    private final double fail;
    
    public Analyzer(List<Integer> result) {
        this.result = result;
        
        int successCnt = 0, failCnt = 0;
        
        for (int i : this.result) {
            if (i == 1)
                successCnt++;
            else
                failCnt++;
        }
        
        success = (double)successCnt / this.result.size() * 100;
        fail = (double)failCnt / this.result.size() * 100;
    }

    public double getSuccess() {
        return success;
    }

    public double getFail() {
        return fail;
    }
}
