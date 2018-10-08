class Sqrt {

   private static int sqrt(int n){
      if (n == 0) return 0;
      if (n == 1) return 1;

      long a = 1;
      long b = n/2;
      long r = 0;
        
      while (a <= b){
         long mid = (b-a)/2 + a;
         if (mid*mid == n) return (int) mid;
         if (mid*mid > n){
             b = mid-1;
         }
         else{
             r = mid;
             a = mid+1;
         }
      }
      return (int) r;
   }

   public static void main(String[] args){
      System.out.println(sqrt(1204));
   }
}
