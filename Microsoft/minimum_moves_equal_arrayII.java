class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int middle = nums[nums.length / 2];

        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - middle);
        }
        return moves;
    }
}