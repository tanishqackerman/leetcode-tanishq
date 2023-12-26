class Solution {
    public int hIndex(int[] citations) {
        return citations.length - binarySearch(citations, 0, citations.length - 1, citations.length);
    }

    public int binarySearch(int[] citations, int l, int r, int n) {
        if (l > r) return l;
        int mid = l + (r - l) / 2;
        if (citations[mid] < n - mid) return binarySearch(citations, mid + 1, r, n);
        return binarySearch(citations, l, mid - 1, n);
    }
}