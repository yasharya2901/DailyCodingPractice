import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://leetcode.com/problems/degree-of-an-array/
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int degree = 0;
        for (int i: nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                degree = Math.max(degree, 1);
            }
            else {
                int freq = map.get(i);
                map.put(i, freq + 1);
                degree = Math.max(degree, freq + 1);
            }
        }
        HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == degree && !map2.containsKey(nums[i])){
                map2.put(nums[i], new ArrayList<Integer>());
            }
            if (map.get(nums[i]) == degree) {
                map2.get(nums[i]).add(i);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int i : map2.keySet()) {
            ArrayList<Integer> arr = map2.get(i);
            int length = (arr.size() == 1) ? 1 : (arr.get(arr.size() - 1) - arr.get(0)) + 1;
            minLength = Math.min(minLength, length);
        }
        return minLength;
    }
}
