class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = nums[0] == 1 ? 1 : 0, rep = Math.max(count, 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                count = 1;
            } else if (nums[i] == 1) count++;
            rep = Math.max(rep, count);
        }
        return rep;
    }
}