class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;
        int[] palindromeLengths = new int[1 << n];

        for (int mask = 1; mask < (1 << n); mask++) {
            if (isPalindrome(s, mask)) {
                palindromeLengths[mask] = Integer.bitCount(mask);
            }
        }

        for (int mask1 = 1; mask1 < (1 << n); mask1++) {
            for (int mask2 = mask1 + 1; mask2 < (1 << n); mask2++) {
                if ((mask1 & mask2) == 0) {
                    maxProduct = Math.max(maxProduct, palindromeLengths[mask1] * palindromeLengths[mask2]);
                }
            }
        }

        return maxProduct;
    }

    private boolean isPalindrome(String s, int mask) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left < s.length() && (mask & (1 << left)) == 0) left++;
            while (right >= 0 && (mask & (1 << right)) == 0) right--;
            if (left < right && s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
