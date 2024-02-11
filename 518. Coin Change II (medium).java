class Solution {

    static int ks(int i, int w, int[] coins, Integer[][] cache) {
        if (w == 0) return 1;
        if (i < 0) return 0;
        if (cache[i][w] != null) return cache[i][w];
        int notpicked = ks(i - 1, w, coins, cache);
        int picked = coins[i] > w ? 0 : ks(i, w - coins[i], coins, cache);
        return cache[i][w] = notpicked + picked;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] cache = new Integer[n + 1][amount + 1];
        return ks(n - 1, amount, coins, cache);
    }
}