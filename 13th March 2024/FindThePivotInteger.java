
public class FindThePivotInteger {
    public int pivotInteger(int n) {
        if (n < 2) return n;
        int[] prefixSum = new int[n];
        prefixSum[0] = 1;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = (i+1) + prefixSum[i-1];
        }

        int lastNum = prefixSum[prefixSum.length - 1];
        for (int i = 1; i < prefixSum.length; i++) {
            if (lastNum - prefixSum[i] == prefixSum[i-1]){
                return (i+1);
            }
        }

        return -1;
    }    
}

class OptimizedSolution {
    public int pivotInteger(int n) {
        int sum = (n * (n+1))/2;
        int pivot = (int) Math.sqrt(sum);
        if (sum == (pivot*pivot)) return pivot;
        return -1;
    }
}