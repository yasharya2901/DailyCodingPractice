import java.util.List;

public class diagonal {
    /*
     * https://www.hackerrank.com/challenges/diagonal-difference/problem
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int firstD = 0, secondD = 0;
        for (int i = 0; i < arr.size(); i++) {
            firstD += arr.get(i).get(i);
            secondD += arr.get(i).get(arr.size() - 1 -i);
        }
        
        return Math.abs(firstD - secondD);
    }
}