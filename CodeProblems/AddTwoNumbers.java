// LeetCode problem to add two numbers represented by linked lists.
// One digit per link, from right to left of the number and head to
// tail of the list. So, 123 would be 3->2->1. The numbers are 
// positive.
//
// Being this is standalone, included are functions to create these
// lists.
// -jrg

class AddTwoNumbers {

   private static class ListNode {
      private final int val;
      private ListNode next = null;

      private ListNode(int val){
         this.val = val;
      }
   }

   private static ListNode createList(int[] A){
      ListNode head = null;
      ListNode curr = null;
      for (int i : A){
         ListNode temp = new ListNode(i);
         if (head == null){
            head = temp;
            curr = temp;
         }
         else{
            curr.next = temp;
            curr = curr.next;
         }
      }
      return head;
   }

   private static void print(ListNode head){
      System.out.print("[");
      while (head != null){
         System.out.print(head.val);
         if (head.next != null)
            System.out.print(", ");
         head = head.next;
      }
      System.out.println("]");
   }

   public static ListNode add(ListNode A, ListNode B){
      if (A == null) return B;
      if (B == null) return A;

      int carry = 0;
      ListNode head = null;
      ListNode curr = null;

      while (A != null && B != null){
         int val = A.val + B.val + carry;
         if (val > 9){
            carry = 1;
            val -= 10;
         }
         else{
            carry = 0;
         }
         ListNode temp = new ListNode(val);
         if (head == null){
            head = temp;
            curr = temp;
         }
         else{
            curr.next = temp;
            curr = curr.next;
         }
         A = A.next;
         B = B.next;
      }
      A = (A != null) ? A : B;
      while (A != null){
         int val = A.val + carry;
         if (val > 9){
            carry = 1;
            val -= 10;
         }
         else{
            carry = 0;
         }
         curr.next = new ListNode(val);
         curr = curr.next;
         A = A.next;
      }
      if (carry == 1)
         curr.next = new ListNode(carry);
      return head;
   }

   public static void main(String[] args){
      int[] A = {1,9,9,9,9,9,9,9,9,9};
      int[] B = {9};
      
      ListNode listA = createList(A);
      ListNode listB = createList(B);

      ListNode listS = add(listA, listB);

      print(listA);
      print(listB);
      print(listS);
   }
}
