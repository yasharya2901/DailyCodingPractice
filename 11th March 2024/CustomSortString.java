import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


/*
 * https://leetcode.com/problems/custom-sort-string/
 */

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, new Comparator<Character>(){
            public int compare(Character a, Character b) {
                if(!map.containsKey(a) && !map.containsKey(b)) {
                    return -1;
                } else if (!map.containsKey(a) && map.containsKey(b)) {
                    return 1;
                } else if (map.containsKey(a) && !map.containsKey(b)) {
                    return -1;
                } else if (map.get(a) > map.get(b)) {
                    return 1;
                } else if (map.get(a) < map.get(b)){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
