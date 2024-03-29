// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        int maxCount = 0;
        long res = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == max) {
                maxCount++;
            }
            if (maxCount == k) {
                while (maxCount >= k) {
                    res += nums.length - j;
                    if (nums[i] == max) {
                        maxCount--;
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }
}
