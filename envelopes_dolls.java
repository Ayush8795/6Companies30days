class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        int[] dp = new int[heights.length];
        int len = 0;

        for (int num : heights) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}