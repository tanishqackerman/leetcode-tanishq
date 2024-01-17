class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, sum = 0, rep = nums[0];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            rep = Math.max(rep, sum);
            if (sum < 0) sum = 0;
        }
        return rep;
    }
}