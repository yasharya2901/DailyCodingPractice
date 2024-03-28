public class MinimumLengthofStringAfterDeletingSimilarEnds{
    /*
     * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
     */
    public int minimumLength(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1)) return s.length();

        int left = 0;
        int right = s.length() -1;

        while (left <= right && s.charAt(left) == s.charAt(right)) {
            if (left == right) return 1;
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            while (left < s.length() && s.charAt(left) == leftChar) {
                left++;
            }
            while (right >= 0 && s.charAt(right) == rightChar){
                right--;
            }
        }

        if (left > right) return 0;

        return right - left + 1;

    }
}
