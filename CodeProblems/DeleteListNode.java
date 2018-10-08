class DeleteListNode {

   // node class to match LeetCode
   private static class ListNode {
      private ListNode next = null;
      private int val;
      private ListNode(int val){
         this.val = val;
      }
   }

   // helper to print out the linked list
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

   // create a linked list from an int array
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

   // return the node for the given value
   private static ListNode findVal(ListNode root, int val){
      if (root == null) return null;

      ListNode curr = root;
      while(curr != null){
         if (curr.val == val) return curr;
         curr = curr.next;
      }
      return null;
   }

   // O(1) delete of a node in a linked list. It returns failure
   // for either an empty list, or if you attempt to delete the
   // tail node - O(1) removal of a single linked list doesn't 
   // support it.
   private static boolean deleteNode(ListNode node){
      if (node == null) return false;
      if (node.next == null) return false;

      ListNode next = node.next;
      node.val = next.val;
      node.next = next.next;
      next.next = null;
      node = null;
      return true;
   }

   public static void main(String[] args){
      int[] A = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
 
      System.out.print("Our list - ");     
      ListNode listA = createList(A);
      print(listA);
      System.out.println();

      int[] B = {1, 3, 21, 5, 5, 7, 21, 9};
      for (int val : B){
         System.out.print("Removing " + val + " ");
         ListNode temp = findVal(listA, val);
         if (temp != null)
            System.out.print("found");
         else
            System.out.print("not found");

         if (deleteNode(temp))
            System.out.println(" - removed");
         else
            System.out.println(" - list not changed");
      }
      System.out.println();

      System.out.print("Our resulting list - ");
      print(listA);
   }
}
