import java.util.Arrays;

class Solution {

    public int robber(int i, int[] nums, int[] cache) {
        if (i < 0) return 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = nums[i] + Math.max(robber(i - 2, nums, cache), robber(i - 3, nums, cache));
    }

    public int rob(int[] nums) {
        int[] cache = new int[nums.length + 1];
        Arrays.fill(cache, -1);
        return Math.max(robber(nums.length - 2, nums, cache), robber(nums.length - 1, nums, cache));
    }
}