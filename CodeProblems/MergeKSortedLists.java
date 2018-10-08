import java.util.Queue;
import java.util.PriorityQueue;

class MergeKSortedLists {

   public static ListNode mergeKSortedLists(ListNode[] lists){
      if (lists == null) return null;
        
      Queue<ListNode> pqueue = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
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

   public static void main(String[] args){
   }
}
