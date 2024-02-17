class Solution {

    public int ks(int i, int[] coins, Integer[][] cache, int tar) {
        if (i == 0) {
            if (tar == 0 && coins[0] == 0)
                return 2;
            if (tar == 0 || tar == coins[0])
                return 1;
            return 0;
        }
        if (cache[i][tar] != null) return cache[i][tar];
        int notpicked = ks(i - 1, coins, cache, tar);
        int picked = tar < coins[i] ? 0 : ks(i - 1, coins, cache, tar - coins[i]);
        return cache[i][tar] = notpicked + picked;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int tot = 0;
        for (int i = 0; i < nums.length; i++) tot += nums[i];
        if (tot - target < 0)
            return 0;
        if ((tot - target) % 2 == 1)
            return 0;
        int s2 = (tot - target) / 2;
        Integer[][] cache = new Integer[n + 1][s2 + 1];
        return ks(n - 1, nums, cache, s2);
    }
}