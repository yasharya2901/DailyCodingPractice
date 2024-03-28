public class ProductOfArrayExceptSelf{
    public int[] productExceptSelf(int[] nums) {
        long prod = 1;
        boolean foundZero = false;
        boolean secondZero = false;
        for (int i : nums) {
            if (foundZero && i == 0) {
                secondZero = true;
                break;
            }     
            if (i == 0) {
                foundZero = true;
                continue;
            }
            prod = prod * i;
        }

        if (secondZero) return new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (foundZero) {
                if (nums[i] == 0) {
                    nums[i] = (int) prod;
                    continue;
                }
                nums[i] = 0;
                continue;
            } 
            nums[i] = (int) prod/nums[i];
        }
        return nums;
    }
}

class OptimizedUsingLeftAndRightProduct {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}
