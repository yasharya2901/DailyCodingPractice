/*
 * https://leetcode.com/problems/minimum-common-value/description/?envType=daily-question&envId=2024-03-09
 */

public class MinimumCommonValue {

    // Brute Force TC: O(N logN)
    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            // int i = 0, j = 0;
    
            for (int i = 0; i < nums2.length; i++) {
                if (search(nums2[i], nums1)) {
                    return nums2[i];
                }
            }
            return -1;
        }
    
        public boolean search(int num, int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start)/2;
                if (arr[mid] == num) {
                    return true;
                } else if (arr[mid] > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
    
            return false;
        }
    }

    // Optimized using Two Pointers
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }
        return -1;    
    }    
}
