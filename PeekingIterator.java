// Generic Peeking Iterator Leetcode Java implementation
// -jrg

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

class PeekingIterator<E> implements Iterator<E> {
    private final Iterator<E> iterator;
    private E nextElement = null;

    public PeekingIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }

    public E peek() {
        return nextElement;
    }

    @Override
    public E next() {
        E temp = nextElement;

        if (iterator.hasNext())
           nextElement = iterator.next();
        else
          nextElement = null;

        return temp;
    }

    @Override
    public boolean hasNext() {
        return (nextElement != null);
    }

    public static void main(String[] args){
       Integer[] numbers = {1, 3, 5, 7, 9};
       String[] words = {"this", "is", "a", "test", "of", "the", "emergency", 
          "broadcast", "system"};

       List<Integer> intList = Arrays.asList(numbers);
       List<String> stringList = Arrays.asList(words);

       Iterator<Integer> intIt = intList.iterator();
       Iterator<String> stringIt = stringList.iterator();

       PeekingIterator<Integer> intPi = new PeekingIterator<Integer>(intIt);
       PeekingIterator<String> stringPi = new PeekingIterator<String>(stringIt);

       while (intPi.hasNext()){
          System.out.println("peek = " + intPi.peek() + ", next = " + intPi.next());
       }

       while (stringPi.hasNext()){
          String peek = stringPi.peek();
          System.out.println("peek = " + stringPi.peek() + ", next = " + stringPi.next());
       }
    }
}
