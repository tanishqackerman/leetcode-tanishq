class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int rep = Integer.MIN_VALUE;
        while (l < r) {
            rep = Math.max(rep, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) r--;
            else l++;
        }
        return rep;
    }
}