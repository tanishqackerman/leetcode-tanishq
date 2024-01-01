import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final HashMap<Integer, Integer> mal = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mal.containsKey(nums[i])) mal.put(nums[i], i);
            else {
                if (i - mal.get(nums[i]) <= k) return true;
                else mal.put(nums[i], i);
            }
        }
        return false;
    }
}