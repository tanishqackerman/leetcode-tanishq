import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rep = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == 0) {
                        rep.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        r--;
                    } else if (nums[i] + nums[l] + nums[r] < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return rep;
    }
}