import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mal = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mal.put(nums[i], mal.getOrDefault(nums[i], 0) + 1);
            if (mal.get(nums[i]) > nums.length / 2) return nums[i];
        }
        return -1;
    }
}