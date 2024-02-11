class Solution {

    static int ks(int i, int w, int[] coins, Integer[][] cache) {
        if (i == 0) {
            if (w % coins[0] == 0) return w / coins[0];
            else return (int) Math.pow(10, 9);
        }
        if (cache[i][w] != null) return cache[i][w];
        int notpicked = ks(i - 1, w, coins, cache);
        int picked = coins[i] > w ? Integer.MAX_VALUE : 1 + ks(i, w - coins[i], coins, cache);
        return cache[i][w] = Math.min(notpicked, picked);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] cache = new Integer[n + 1][amount + 1];
        int rep = ks(n - 1, amount, coins, cache);
        if (rep >= (int) Math.pow(10, 9))
            return -1;
        return rep;
    }
}