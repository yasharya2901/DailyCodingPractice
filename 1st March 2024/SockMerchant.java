import java.util.HashMap;
import java.util.List;

public class SockMerchant{

    /*
     * https://www.hackerrank.com/challenges/sock-merchant/copy-from/372532470
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.size(); i++) {
            if (!map.containsKey(ar.get(i))) {
                map.put(ar.get(i), 1);
            } else {
                int freq = map.get(ar.get(i));
                map.put(ar.get(i), freq + 1);
            }
        }
        int count = 0;
        for (int i : map.values()) {
            count += i/2;
        }
        return count;
    }
}