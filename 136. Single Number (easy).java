class Solution {
    public int singleNumber(int[] nums) {
        int rep = 0;
        for (int i = 0; i < nums.length; i++) rep ^= nums[i];
        return rep;
    }
}