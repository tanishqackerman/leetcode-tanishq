class Solution {

    public int binarySearch(int[] nums, int l, int r) {
        if (l > r)
            return l;
        int mid = l + (r - l) / 2;
        if (nums[mid] == nums[r])
            return binarySearch(nums, l, r - 1);
        else if (nums[mid] > nums[r])
            return binarySearch(nums, mid + 1, r);
        else
            return binarySearch(nums, l, mid);
    }

    public int findMin(int[] nums) {
        return nums[binarySearch(nums, 0, nums.length - 1)];
    }
}