class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1, ind = 1;
        while (i < nums.length) {
            if (nums[i - 1] != nums[i]) {
                nums[ind] = nums[i];
                ind++;
            }
            i++;
        }
        return ind;
    }
}