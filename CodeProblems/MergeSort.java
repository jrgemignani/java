// Classic MergeSort, my favorite sorting algorithm 
// O(nLogn)
// -jrg

class MergeSort {

   public static void mergeSort(int[] A, int i, int j){
      if (A == null) return;
      if (i == j) return;

      int len = (j-i+1);
      int half = (len-1)/2;
      
      mergeSort(A, i, i+half);
      mergeSort(A, i+half+1, j);
     
      int[] temp = new int[len];
      int k = i;
      int l = i+half+1;
      int m = 0;
      while ((k <= i+half) && (l <= j)){
         if (A[k] <= A[l])
            temp[m++] = A[k++];
         else
            temp[m++] = A[l++];
      }
      while (k <= i+half){
         temp[m++] = A[k++];
      }
      while (l <= j){
         temp[m++] = A[l++];
      }
      for (m = 0; m < len; m++)
         A[i+m] = temp[m];
   }

   private static void print(int[] A){
      if (A == null) return;
      int len = A.length;

      System.out.print("[");
      for (int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(A[i] + ", ");
         else
            System.out.println(A[i] + "]");
      }
   }

   public static void main(String[] args){
      int[] A = {3, 1, 5, 2, 7, 6, 11, 4, 9, 10, 8};
      print(A);
      mergeSort(A, 0, A.length-1);
      print(A);
   }
}
