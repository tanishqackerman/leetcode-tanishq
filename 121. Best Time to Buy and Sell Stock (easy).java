class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 0, n = prices.length, d = 0, rep = 0;
        while (j < n) {
            d = prices[j] - prices[i];
            if (d < 0) {
                d = 0;
                i = j;
            }
            j++;
            rep = Math.max(rep, d);
        }
        return rep;
    }
}