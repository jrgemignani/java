import java.util.NoSuchElementException;

class PeakElement {

   private static <T> void print(T[] A){
      System.out.print("[");
      int len = A.length;
      for (int i = 0; i < len; i++){
         if (i+1 < len)
            System.out.print(A[i] + ", ");
         else
            System.out.print(A[i]);
      }
      System.out.println("]");
   }

   public static int getPeak(Integer[] A) throws NullPointerException, NoSuchElementException{
      if (A == null) 
         throw new NullPointerException("null array passed");
      if (A.length == 0) 
         throw new NoSuchElementException("empty array passed");
      
      int len = A.length;
      int a = 0;
      int b = len-1;

      while (a != b){
         int i = (b+a)/2;
         if (i == 0)
           return (A[i] > A[i+1]) ? A[i] : A[i+1];
         if (A[i-1] < A[i] && A[i] > A[i+1])
            return A[i];
         if (A[i-1] < A[i]) 
            a = i+1;
         else
            b = i-1;
      }
      return A[a];
   }

   public static void main(String[] args){
      Integer[] A1 = {0, 1, 2, 3, 4, 5, 4, 2, 1};
      Integer[] A2 = {1};
      Integer[] A3 = {1, 2};
      Integer[] A4 = {2,1};
      Integer[] A5 = {5, 4, 3, 2, 1, 0, -1, -2};
      Integer[] A6 = {1, 2, 3, 4, 5};

      Integer[][] As = {A1, A2, A3, A4, A5, A6};
      for (Integer[] A : As){
         print(A);
         System.out.println(getPeak(A));
      }
   }
}
