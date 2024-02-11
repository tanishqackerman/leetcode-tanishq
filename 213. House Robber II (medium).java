class Solution {

    public int robber(int i, int[] nums, Integer[][] cache, int f) {
        if (i >= nums.length - f) return 0;
        if (cache[i][f] != null) return cache[i][f];
        return cache[i][f] = Math.max(nums[i] + robber(i + 2, nums, cache, f), robber(i + 1, nums, cache, f));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        Integer[][] cache = new Integer[nums.length + 1][2];
        return Math.max(robber(0, nums, cache, 1), robber(1, nums, cache, 0));
    }
}