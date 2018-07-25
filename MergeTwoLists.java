// Leetcode problem of merging two sorted linked lists.
// O(n) and in place
// -jrg

class MergeTwoLists{

   private static class ListNode {
      private ListNode next = null;
      private final int val;
      private ListNode(int val){
         this.val = val;
      }
   }

   // merge list A and B, and return the head of the merged list
   private static ListNode merge(ListNode A, ListNode B){
      if (A == null) return B;
      if (B == null) return A;

      ListNode head = null;
      if (A.val <= B.val){
         head = A;
         A = A.next;
      }
      else{
         head = B;
         B = B.next;
      }

      ListNode tail = head;
      while(A != null && B != null){
         if (A.val <= B.val){
            tail.next = A;
            tail = A;
            A = A.next;
         }
         else{
            tail.next = B;
            tail = B;
            B = B.next;
         }
      }
      if (A != null){
         tail.next = A;
         A = null;
      }
      if (B != null){
         tail.next = B;
         B = null;
      }
      return head;
   }

   // print the linked list out
   private static void print(ListNode head){
      System.out.print("[");

      while(head != null){
         if (head.next != null)
            System.out.print(head.val + ", ");
         else
            System.out.println(head.val + "]");
         head = head.next;
      }
   }

   // create a linked list from the provided integer array
   private static ListNode create(int[] A){
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

   public static void main(String[] args){
      int[] A = {1, 3, 5, 7, 9};
      int[] B = {2, 4, 6, 8, 10};
 
      ListNode listA = create(A);
      ListNode listB = create(B);
      ListNode result = null;

      print(listA);
      print(listB);
      result = merge(listA, listB);
      print(result);
   }
}
