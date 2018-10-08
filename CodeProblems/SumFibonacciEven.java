// Sum the even Fibonacci numbers - interview question
// O(n) time complexity, O(1) space
// 

class SumFibonacciEven {

   // public static function to calculate Fibonacci sequence and sum up
   // all of the even Fibonacci numbers to n. 
   // Note: this Fibonacci sequence starts at 0 and uses the DP solution.
   // Note: throws IllegalArgumentException for any n less than 0
   public static int sumFibonacciEven(int n) throws IllegalArgumentException {
      // throw IllegalArgumentException if less than 0
      if (n < 0)
         throw new IllegalArgumentException("A negative value was given");

      // these are our base cases
      if (n == 0) return 0;
      if (n == 1) return 0;
      
      int f1 = 0;
      int f2 = 1;
      int fn = 0;
      int sum = 0;
      
      // fib(n) = fib(n-1) + fib(n-2) or in this case 
      // fn = f1 + f2
      for (int i = 2; i <= n; i++){
         fn = f1 + f2;
         f1 = f2;
         f2 = fn;
         if (fn % 2 == 0) sum += fn;
      }
      return sum;
   }

   // main entry point if this class is run
   public static void main(String[] args) throws IllegalArgumentException {
      int[] A = {0, 1, 2, 3, 4, 7, -1};

      // Fibonacci is 0, 1, 1, 2, 3, 5, 8, 11, ...
      // for index    0  1  2  3  4  5  6   7
      // Iterate through A and output the results
      for (int a : A){
         int sum = sumFibonacciEven(a);
         System.out.println("Sum of even Fibonacci up to " + a 
            + " = " + sum);
      }
   }

}
