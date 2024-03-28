import java.util.HashMap;

/*
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/
 */

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int i: nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                maxFreq = Math.max(maxFreq, 1);
            }
            else {
                int freq = map.get(i);
                map.put(i, freq + 1);
                maxFreq = Math.max(maxFreq, freq + 1);
            }
        }

        int count = 0;
        for (int i: nums) {
            if (map.get(i) == maxFreq) {
                count++;
            }
        }

        return count;


    }
}