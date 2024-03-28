/*
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;
        List<Integer> list = new ArrayList<>();
        List<Integer> prefList = new ArrayList<>();
        ListNode temp = head;
        int sum = 0;

        do{
            list.add(temp.val);
            sum+= temp.val;
            if (sum == 0) {
                list = new ArrayList<Integer>();
            }
            temp = temp.next;
        } while(temp != null);

        if (list.isEmpty()) return null;

        prefList.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            prefList.add(list.get(i) + prefList.get(i-1));
        }

        HashMap<Integer, Integer> indexLocation = new HashMap<>();
        HashMap<Integer, Integer> startEndLocation = new HashMap<>();
        for (int i = 0; i < prefList.size();i++) {
            int num = prefList.get(i);
            if (indexLocation.containsKey(num)) {
                startEndLocation.put(indexLocation.get(num) + 1, i);
            }
            indexLocation.put(prefList.get(i), i);
        }


        int i = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < list.size()){
            int num = list.get(i);
            if (startEndLocation.containsKey(i)) {
                i = startEndLocation.get(i);
                i++;
                continue;
            }
            result.add(num);
            i++;
        }

        ListNode fresult = new ListNode(result.get(0));
        temp = fresult;
        i = 1;
        while (i < result.size()) {
            temp.next = new ListNode(result.get(i));
            temp = temp.next;
            i++;
        }

        return fresult;


    }
}
