import java.util.Arrays;
import java.util.Comparator;



public class MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int count = 1;
        int a = 0;
        for (int i = 1; i < points.length; i++) {
            if (!isIntervalLieBetween(points[i], points[a])) {
                a=i;
                count++;
            }
        }


        return count;
    }

    public static boolean isIntervalLieBetween(int[] interval, int[] givenInterval) {
        if ((interval[1] < givenInterval[0]) || (interval[0] > givenInterval[1])){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        System.out.println(findMinArrowShots(points));
    }
    
}
