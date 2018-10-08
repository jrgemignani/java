// LeetCode problem to validate a Sudoku puzzle.
// O(m*n) time complexity
// -jrg

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class ValidSudoku {

   private static boolean isValidSudoku(char[][] board){
      if (board == null) return false;
      if (board[0].length == 0) return false;

      Map<Integer, Set<Character>> rows = new HashMap<Integer, Set<Character>>();
      Map<Integer, Set<Character>> columns = new HashMap<Integer, Set<Character>>();
      Map<Integer, Set<Character>> zones = new HashMap<Integer, Set<Character>>();

      for(int row = 0; row < board.length; row++){
         for(int column = 0; column < board[0].length; column++){
            if (board[row][column] == '.') continue;
            
            Character c = board[row][column];
            if (!rows.containsKey(row))
               rows.put(row, new HashSet<Character>());
            Set<Character> rSet = rows.get(row);
            if (rSet.contains(c)) return false;
            rSet.add(c);

            if (!columns.containsKey(column))
               columns.put(column, new HashSet<Character>());
            Set<Character> cSet = columns.get(column);
            if (cSet.contains(c)) return false;
            cSet.add(c);

            int zone = (row/3)*3 + (column/3);
            if (!zones.containsKey(zone))
               zones.put(zone, new HashSet<Character>());
            Set<Character> zSet = zones.get(zone);
            if (zSet.contains(c)) return false;
            zSet.add(c);
         }
      }
      return true;
   }

   public static void main(String[] args){
      char[][] puzzle1 = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

      char[][] puzzle2 = {{'8','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

      System.out.println(isValidSudoku(puzzle1));
      System.out.println(isValidSudoku(puzzle2));
   }
}
