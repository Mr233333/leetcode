import java.util.List;
import java.util.Stack;

public class SegmentTurn {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> swap = new Stack<ListNode>();
        ListNode temp = head;
        ListNode result = null;
        boolean first = false;
        while (head != null) {
            if (swap.size() == k) {
                while (swap.size() > 0) {
                    if (!first) {
                        result = swap.pop();
                        temp = result;
                        first = true;
                    } else {
                        temp.setNext(swap.pop());
                        temp = temp.getNext();
                    }
                }
                swap.push(head);
            } else {
                swap.push(head);
            }
            head = head.getNext();
        }
        if(!swap.empty()){
            temp.setNext(swap.elementAt(0));
        }
        return result;
    }


    public static void main(String args[]) {
        ListNode node = new ListNode(0);
        int[] data = {1, 2, 3, 4, 5};
        ListNode temp = node;
        for (int i :
                data) {
            temp.setNext(new ListNode(i));
            temp = temp.getNext();
        }
        SegmentTurn segmentTurn = new SegmentTurn();
        segmentTurn.reverseKGroup(node.getNext(), 3);
    }
}
