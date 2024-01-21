class Solution {
    public int[] rearrangeArray(int[] nums) {
        int j = 1, i = 0, k = 0, n = nums.length;
        int[] rep = new int[n];
        while (k < n) {
            if (nums[k] >= 0) {
                rep[i] = nums[k];
                i += 2;
            } else {
                rep[j] = nums[k];
                j += 2;
            }
            k++;
        }
        return rep;
    }
}