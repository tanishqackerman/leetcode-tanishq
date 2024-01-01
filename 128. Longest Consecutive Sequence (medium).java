import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1, rep = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) continue;
            if (nums[i - 1] + 1 == nums[i]) count++;
            else count = 1;
            rep = Math.max(rep, count);
        }
        return rep;
    }
}