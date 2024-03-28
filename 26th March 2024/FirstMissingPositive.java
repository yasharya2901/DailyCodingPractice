/*
 * https://leetcode.com/problems/first-missing-positive/submissions/1214227368/
 */

import java.util.HashSet;
import java.util.PriorityQueue;

public class FirstMissingPositive {
    // Initial Approach (Brute Force)
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                continue;
            }
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == Integer.MAX_VALUE) return 1;

        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;


    }
    
}

class Approach2{
    // Using Priority Queue
    public int firstMissingPositive(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                continue;
            }
            pq.add(nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (pq.isEmpty() || pq.peek() > 1) return 1;

        int prev = pq.poll();
        int curr = 0;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            if (curr - prev > 1) {
                return prev + 1;
            }
            prev = curr;
        }

        return max + 1;


    }
}

// Optimized Solution
class FinalSolution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;

        boolean oneExist = false;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 1) {
                oneExist = true;
            }
            if (nums[i] < 1 || nums[i] > size) {
                nums[i] = 1;
            }
        }

        if (!oneExist) return 1;

        for (int i = 0; i < size; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] > 0) {
                nums[idx - 1] = nums[idx - 1] * -1;
            }
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return size + 1;
    }
}