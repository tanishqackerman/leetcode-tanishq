class Solution {
    public void sortColors(int[] nums) {
        int o = 0, z = 0, t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) z++;
            else if (nums[i] == 1) o++;
            else t++;
        }
        int i = 0;
        while (z-- > 0) {
            nums[i] = 0;
            i++;
        }
        while (o-- > 0) {
            nums[i] = 1;
            i++;
        }
        while (t-- > 0) {
            nums[i] = 2;
            i++;
        }
    }
}