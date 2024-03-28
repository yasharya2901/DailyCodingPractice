// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray{
    // O(n), O(n) initial solution
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int[] freq = new int[nums.length + 1];
        for (int num: nums) {
            freq[num]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                list.add(i);
            }
        }
        return list;
    }

}

class Optimized{
    // O(n), O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] < 0) {
                list.add(idx);
            }
            nums[idx - 1] = nums[idx - 1] * -1;
        }
        return list;
    }
}