import java.util.Arrays;

class Solution {

    public int binarySearch(int[] potions, int s, long success, int l, int r) {
        if (l > r) return l;
        int mid = l + (r - l) / 2;
        long x = (long) potions[mid] * s;
        if (x >= success) return binarySearch(potions, s, success, l, mid - 1);
        else if (x < success) return binarySearch(potions, s, success, mid + 1, r);
        return mid;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] rep = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            rep[i] = potions.length - binarySearch(potions, spells[i], success, 0, potions.length - 1);
        }
        return rep;
    }
}