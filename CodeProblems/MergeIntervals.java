import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Wrapper class for the mergeIntervals LeetCode problem. It also includes 
// tests -jrg
//
class MergeIntervals {

   // Method takes a list of intervals [(1,3), (3,7), (4,6), (8,10)] and 
   // returns a merged list of intervals [(1,7), (8,10)]. If the passed 
   // list is null or 0, it will return an empty List. The original list
   // will not be modified in any way.
   public static List<Interval> mergeIntervals(List<Interval> intervals){
      List<Interval> merged = new ArrayList<Interval>();
      if (intervals == null || intervals.size() == 0) 
         return merged;

      // copy the input list
      List<Interval> I = new ArrayList<Interval>();
      for (Interval i : intervals){
         I.add(new Interval(i.start, i.end));
      }

      // sort the copy
      Collections.sort(I, new Comparator<Interval>(){
         @Override
         public int compare(Interval lhs, Interval rhs){
            if (lhs.start == rhs.start) return 0;
            return (lhs.start < rhs.start) ? -1 : 1;
         }
      });

      // merge the intervals, seed with the first
      int start = I.get(0).start;
      int end = I.get(0).end;
      for (Interval i : I){
         // if contained within
         if (i.end <= end) continue;
         // if disjoint
         if (i.start > end){
            merged.add(new Interval(start, end));
            start = i.start;
            end = i.end;
         }
         // if overlaping
         else{
            end = i.end;
         }
      }
      // add in the last
      merged.add(new Interval(start, end));
      // return the list
      return merged;
   }

   // method to print out a List of T
   public static <T> void print(List<T> list){
      System.out.print("[");
      for (int i = 0; i < list.size(); i++){
         if (i+1<list.size())
            System.out.print(list.get(i) + ", ");
         else
            System.out.print(list.get(i));
      }
      System.out.println("]");
   }

   // method to create a list of test intervals
   public static List<Interval> createList(){
      List<Interval> I = new ArrayList<Interval>();
      I.add(new Interval(2,3));
      I.add(new Interval(1,3));
      I.add(new Interval(8,13));
      I.add(new Interval(1,3));
      I.add(new Interval(15,23));
      I.add(new Interval(2,5));
      I.add(new Interval(5,6));
      return Collections.unmodifiableList(I);
   }

   public static void main(String[] args){
      List<Interval> intervals = createList();
      print(intervals);

      List<Interval> merged = mergeIntervals(intervals);
      print(merged);

      merged = mergeIntervals(null);
      print(merged);

      merged = mergeIntervals(new ArrayList<Interval>());
      print(merged);
   }
}
