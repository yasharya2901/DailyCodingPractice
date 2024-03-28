import java.util.List;

public class apple_and_orange {
    /*
     * https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        // s = 7, t = 11
        // a = 5, b = 15
        // m = 3, n = 2
        // m distances from a = [-2, 2, 1]
        // n distances from b = [5, -6]
    
        int m = apples.size();
        int n = oranges.size();
        
        int countOfApples = 0;
        int countOfOranges = 0;
        for (int i = 0; i < m; i++) {
            int posOfApple = a + apples.get(i);
            if (posOfApple >= s && posOfApple <= t) {
                countOfApples++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int posOfOrange = b + oranges.get(i);
            if (posOfOrange >= s && posOfOrange <= t) {
                countOfOranges++;
            }
        }
        System.out.println(countOfApples);
        System.out.println(countOfOranges);
    }
}