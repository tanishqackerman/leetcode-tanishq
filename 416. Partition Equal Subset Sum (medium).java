class Solution {

    public static boolean subset(int i, int[] arr, int k, Boolean[][] cache, int sum) {
        if (i < 0 || sum > k) return false;
        if (sum == k) return cache[i][sum] = true;
        if (cache[i][sum] != null) return cache[i][sum];
        return cache[i][sum] = subset(i - 1, arr, k, cache, sum) || subset(i - 1, arr, k, cache, sum + arr[i]);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) k += nums[i];
        if (k % 2 != 0) return false;
        k /= 2;
        Boolean[][] cache = new Boolean[n + 1][k + 1];
        return subset(n - 1, nums, k, cache, 0);
    }
}