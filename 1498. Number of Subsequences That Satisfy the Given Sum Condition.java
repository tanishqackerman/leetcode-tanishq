import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int rep = 0;
        int mod = (int) 1e9 + 7;
        int l = 0, r = nums.length - 1;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) pow[i] = (2 * pow[i - 1]) % mod;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                rep = (rep + pow[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        return rep;
    }
}