class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prev = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
                boolean valid = true;
                for (int k = 0; k < i; k++) {
                    if (k > 0 && nums[k] <= nums[k - 1]) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    for (int k = j + 1; k < n; k++) {
                        if (k == j + 1) {
                            if (nums[k] <= prev) {
                                valid = false;
                                break;
                            }
                        } else if (nums[k] <= nums[k - 1]) {
                            valid = false;
                            break;
                        }
                        prev = nums[k];
                    }
                }
                
                if (valid) count++;
            }
        }
        return count;
   }
}