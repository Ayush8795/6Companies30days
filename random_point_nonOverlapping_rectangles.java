class Solution {

    private int[] prefixSums;
    private int[][] rects;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.prefixSums = new int[rects.length];

        int areaSum = 0;
        for (int i = 0; i < rects.length; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            areaSum += width * height;
            prefixSums[i] = areaSum;
        }
    }
    
    public int[] pick() {
        int target = random.nextInt(prefixSums[prefixSums.length - 1]);
        int rectIndex = binarySearch(target);

        int[] rect = rects[rectIndex];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;

        int x = rect[0] + random.nextInt(width);
        int y = rect[1] + random.nextInt(height);

        return new int[]{x, y};
    }
    private int binarySearch(int target) {
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
