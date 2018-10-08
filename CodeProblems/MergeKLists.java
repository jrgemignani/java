import java.util.Queue;
import java.util.PriorityQueue;

// wrapper class for the LeetCode problem, Merge K Lists. Done on paper, coded, submitted.
// sorry, no test cases for this one.
// -jrg
//
public class MergeKLists {

   public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;
        
      Queue<ListNode> pqueue = new PriorityQueue<ListNode>(lists.length, (a,b) -> a.val - b.val);
        
      for (ListNode list : lists){
         if (list != null) pqueue.add(list);
      }

      if (pqueue.isEmpty()) return null;
        
      ListNode head = pqueue.remove();
      if (head.next != null) pqueue.add(head.next);
      ListNode prev = head;
      while (!pqueue.isEmpty()){
         ListNode curr = pqueue.remove();
         if (curr.next != null) pqueue.add(curr.next);

         prev.next = curr;
         prev = curr;
      }
      return head;
    }
}
