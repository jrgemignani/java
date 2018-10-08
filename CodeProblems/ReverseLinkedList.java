class ReverseLinkedList {

   private static class ListNode {
      private ListNode next = null;
      private int val;
      private ListNode(int val){
         this.val = val;
      }
   }

   private static void print(ListNode head){
      System.out.print("[");
      while(head != null){
         if (head.next != null)
            System.out.print(head.val + ", ");
         else
            System.out.print(head.val);
         head = head.next;
      }
      System.out.println("]");
   }

   private static ListNode createList(int[] A){
      if (A == null) return null;

      int len = A.length;
      ListNode head = new ListNode(A[0]);
      ListNode prev = head;
      for (int i = 1; i < len; i++){
         prev.next = new ListNode(A[i]);
         prev = prev.next;
      }
      return head;
   }

   private static ListNode reverseRecursive(ListNode node){
      if (node == null) return null;

      ListNode head = null;
      if (node.next != null)
         head = reverseRecursive(node.next);
      else
         return node;

      node.next.next = node;
      node.next = null;

      return head;
   }

   private static ListNode reverseIterative(ListNode node){
      if (node == null) return null;

      ListNode curr = node;
      ListNode next = null;
      ListNode prev = null;

      while(curr != null){
         next = curr.next;
         curr.next = prev;
         prev = curr; 
         curr = next; 
      }
      return prev;
   }

   public static void main(String[] args){
      int[] A = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
      int[] B = {1, 3, 5, 5, 7};
      ListNode listA = createList(A);
      print(listA);

      listA = reverseRecursive(listA);
      print(listA);
      
      listA = reverseIterative(listA);
      print(listA);
   }
}
