import java.util.*;

public class Sorting {

  ////////////////////////////////////////
  ///// SELECTION SORT

  // Swaps to entries in a list at positions i and j
  private static void swap(List<Integer> list, int i, int j) {
    Integer temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }

  // Finds index of minimum value in "list" starting from "start" 
  private static int findMin(List<Integer> list, int start) {
    int min = start;
    for (int i = start; i < list.size(); i++) {
      if(list.get(i) < list.get(min)) {
        min = i;
      }
    }
    return min;
   }

  // Sorts the list given as argument using Selection Sort
  public static void selectionSort(List<Integer> list) {
    for(int i = 0; i < list.size(); i++) {
      int minIndex = findMin(list, i);
      // swap the minimum with i-th element
      swap(list, i, minIndex);
    }
  }


  ////////////////////////////////////////
  ///// MAIN METHOD FOR TESTING

  // Sorts a list of 10 random integers
  public static void main(String[] args) {
    Random rand = new Random();

    // Generate list of 10 random integers
    List<Integer> list = new ArrayList<Integer>();
    for (int i=0; i<10; i++) {
      list.add(rand.nextInt(100));
    }

    List l;
    System.out.println("Sorting " + list);

    l = (List) ((ArrayList) list).clone();
    selectionSort(l);
    System.out.println("Result of selection sort: " + l);

    l = (List) ((ArrayList) list).clone();
    insertionSort(l);
    System.out.println("Result of insertion sort: " + l);

    l = (List) ((ArrayList) list).clone();
    l = mergeSort(l);
    System.out.println("Result of merge sort: " + l);
  }

  ////////////////////////////////////////
  ///// INSERTION SORT

  // Sorts the list given as argument using Insertion Sort
  public static void insertionSort(List<Integer> list) {

    for (int i = 0; i < list.size(); i++) {

      int cur = list.get(i);
      int j;
      for (j = i - 1; j >= 0 && cur < list.get(j); j--) {
        list.set(j + 1, list.get(j));
      }

      list.set(j + 1, cur);

    }

  }

  ////////////////////////////////////////
  ///// MERGE SORT

  // Merges two sorted lists a and b into a new sorted list
  public static List<Integer> merge(List<Integer> a,
                                    List<Integer> b) {

    List<Integer> result = new ArrayList<Integer>();

    int i = 0;
    int j = 0;

    while (i < a.size() && j < b.size()) {
      if (a.get(i) < b.get(j)) {
        result.add(a.get(i));
        i++;
      } else {
        result.add(b.get(j));
        j++;
      }
    }

    while (i < a.size()) {
      result.add(a.get(i));
      i++;
    }

    while (j < b.size()) {
      result.add(b.get(j));
      j++;
    }

    return result;

  }

  // Returns a new list which is a sorted copy of the input list
  public static List<Integer> mergeSort(List<Integer> list) {

    // Base case
    if (list.size() <= 1) {
      return list;
    }

    // Middle position in list
    int mid = list.size() / 2;

    // Split the list into left and right sublists
    // subList(s,t) is a sublist from s (incl.) to t (excl.)
    List<Integer> left = list.subList(0, mid);
    List<Integer> right = list.subList(mid, list.size());

    // Recursively sort the two sublists
    left = mergeSort(left);
    right = mergeSort(right);

    // Merge the sorted sublists
    return merge(left, right);
  }

}