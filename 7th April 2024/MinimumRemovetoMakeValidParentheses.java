import java.util.HashSet;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    // Approach 1
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                st.push(i);
            } else if(!st.isEmpty() && s.charAt(i) == ')'){
                st.pop();
            }
        }

        long countOfBracket = 0;
        HashSet<Integer> hs = new HashSet<>();
        while(!st.isEmpty()){
            hs.add(st.pop());
        } 

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(i)) {
                continue;
            }
            if (s.charAt(i) == ')' && countOfBracket == 0) {
                continue;
            }

            sb.append(s.charAt(i));
            if (s.charAt(i) == '('){
                countOfBracket++;
            }
            if (s.charAt(i) == ')') {
                countOfBracket--;
            }
        }
        return sb.toString();
    }
}
