import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Map analysis = new HashMap<Integer, Integer>();
        for (ListNode node : lists) {
            ListNode crusor = node;
            while (crusor != null) {
                if (analysis.containsKey(crusor.getVal())) {
                    Integer total = Integer.parseInt(analysis.get(crusor.getVal()).toString());
                    analysis.put(crusor.getVal(), total + 1);
                } else {
                    analysis.put(crusor.getVal(), 1);
                }
                crusor = crusor.getNext();
            }
        }
        Set<Integer> kesSet = analysis.keySet();
        Integer[] sortedKeys = new Integer[kesSet.size()];
        kesSet.toArray(sortedKeys);
        Arrays.sort(sortedKeys);
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        for (Integer key : sortedKeys) {
            Integer total = Integer.parseInt(analysis.get(key).toString());
            for (int i = 0; i < total; i++) {
                cursor.setNext(new ListNode(key));
                cursor = cursor.getNext();
            }
        }
        return head.getNext();
    }


    public static void main(String[] args) {
        ListNode[] testcase = new ListNode[2];
        int[] first = {-1, 5, 11};
        int[] second = {6, 10};
        ListNode firstHead = new ListNode(-1);
        firstHead.setNext(new ListNode(5));
        firstHead.getNext().setNext(new ListNode(11));
        testcase[0] = firstHead;
        ListNode secondHead = new ListNode(6);
        secondHead.setNext(new ListNode(10));
        testcase[1] = secondHead;
        Solution solution = new Solution();
        solution.mergeKLists(testcase);

    }
}

