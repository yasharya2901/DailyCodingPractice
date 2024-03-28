public class camelCase{
    /*
     * 
     * https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true
     * 
     */
    public static int camelcase(String s) {
        // Write your code here
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                count++;
            }
        }
        return count;
    }
    
}