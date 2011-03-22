package finance.candlePatterns.Core;

public interface BarFilter extends FilterResult {
    public boolean isAppliedFor(Bar bar);
}
