// Leetcode to create Pascal's triangle. It uses the fact that each row 
// is built on the previous, using the formula nCk = nCk*(n-k)/(k+1) 
// with the initial value of nCk being 1.
// -jrg
//

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

   // public static method to create a List of Lists of Integers
   public static List<List<Integer>> generate(int numRows){
      List<List<Integer>> pt = new ArrayList<List<Integer>>();
      for (int n = 0; n < numRows; n++){
         int nCk = 1;
         List<Integer> row = new ArrayList<Integer>();
         for (int k = 0; k <= n; k++){ 
            row.add(nCk);
            nCk = nCk*(n-k)/(k+1);
         }
         pt.add(row);
      }
      return pt;
   }

   // public helper method to print the triangle
   public static <T> void print(List<List<T>> triangle){
      for (List<T> row : triangle){
         for (int i = 0; i < row.size(); i++){
            if (i+1 < row.size())
               System.out.print(row.get(i) + ", ");
            else
               System.out.println(row.get(i));
         }
      }
   }

   // main method to run some tests
   public static void main(String[] args){
      for (int rows = 0; rows <= 7; rows++){
         List<List<Integer>> triangle = generate(rows);
         print(triangle);
         System.out.println();
      }
   }
}
