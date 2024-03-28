import java.util.HashMap;
// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int i = 0, j = 0;
        int count = 0;

        while (j < nums.length) {
            if (!freqMap.containsKey(nums[j])) {
                freqMap.put(nums[j], 1);
            } else {
                freqMap.put(nums[j], freqMap.get(nums[j]) + 1);
            }

            if (freqMap.get(nums[j]) > k) {
                while (i < j && freqMap.get(nums[j]) > k) {
                    freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                    i++; 
                }
            }
            count = Math.max(j - i + 1, count);
            j++;
        }

        return count;
    }
}
