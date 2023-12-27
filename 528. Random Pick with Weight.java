import java.util.Random;

class Solution {

    int[] w;
    int[] pre;

    public Solution(int[] w) {
        this.w = w;
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = w[i] + pre[i - 1];
        }
    }
    
    public int pickIndex() {
        int l = 0, r = pre.length - 1;
        Random rand = new Random();
        int ra = rand.nextInt(pre[r]);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (pre[mid] > ra) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}