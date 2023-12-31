import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mal = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mal.containsKey(target - nums[i])) return new int[] {mal.get(target - nums[i]), i};
            mal.put(nums[i], i);
        }
        return new int[] {};
    }
}