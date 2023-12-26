import java.util.Arrays;

class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int rep = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    rep += r - l;
                    r--;
                } else l++;
            }
        }
        return rep;
    }
}