class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1, ind = -1;
        for (i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                ind = i - 1;
                break;
            }
        }
        if (ind == -1) {
            for (int j = 0; j < n / 2; j++) {
                int temp = nums[j];
                nums[j] = nums[n - j - 1];
                nums[n - j - 1] = temp;
            }
            return;
        }
        int next = n, ni = ind + 1;
        for (int j = n - 1; j >= ind + 1; j--) {
            if (nums[ind] < nums[j] && nums[j] < next) {
                next = nums[j];
                ni = j;
            }
        }
        int temp = nums[ni];
        nums[ni] = nums[ind];
        nums[ind] = temp;
        for (int j = ind + 1; j < (ind + 1 + n) / 2; j++) {
            int t = nums[j];
            nums[j] = nums[n - j + ind];
            nums[n - j + ind] = t;
        }
        // Arrays.sort(nums, ind + 1, n);
    }
}