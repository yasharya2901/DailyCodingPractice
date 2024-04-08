import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch
 */



public class NumberofStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sw = new Stack<Integer>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sw.push(sandwiches[i]);
        }

        Queue<Integer> stu = new LinkedList<>();
        int[] count = new int[2]; 
        for (int i = 0; i < students.length; i++) {
            count[students[i]]++;
            stu.add(students[i]);
        }

        while (!stu.isEmpty() && !sw.isEmpty()) {
            if (count[sw.peek()] == 0) {
                break;
            }
            if (stu.peek() == sw.peek()) {
                int a = stu.poll();
                sw.pop();
                count[a]--;
            } else {
                stu.add(stu.poll());
            }
        }

        return stu.size();
    }
}

class Optimized{
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int i: students) {
            count[i]++;
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (count[sandwiches[i]] == 0) {
                break;
            }
            count[sandwiches[i]]--;
        }

        return count[0] + count[1];
    }
}