import java.util.*;
public class RandomizedQuickSort
{
  static int partition(int [] arr, int p, int q) // p --> starting index (pivot index), q --> last index
  {
    int x = arr[p]; // pivot element
    int i = p; // to search after pivot point
    
    for(int j = i+1; j<=q; j++)
    {
      if(arr[j] <= x) // if small then need to swap (to left)
      {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    
    // Taking (swap) the pivot to the middle.
    // The pivot element no longer need to change, because it's in correct place.
    // This swap makes everything left of pivot smaller and larger in the right.
    int temp = arr[p];
    arr[p] = arr[i];
    arr[i] = temp;
    return i; // new position of old pivot (element), from which further can be gone
  }
  
  static void quicksort(int [] arr, int p, int r) // p --> 0, r --> arr.length - 1 (from main)
  {
    if(p < r) // if there arr 2 or more element in array
    {
      int q = randomP(arr, p, r); // new pivot position
      quicksort(arr, p, q-1); // left subarray (upto left of previous pivot)
      quicksort(arr, q+1, r); // right subarray (from right of previous pivot)
    }
  }
  
  static int randomP(int [] arr, int p, int r)
  {
    // This a complicated one
    // Finding the random from a given range
    // Getting a random from the range difference
    // Adding with minimum to get a random from the range itself (not difference)
    Random random = new Random();
    int range = r - p + 1;
    int i = random.nextInt(range) + p;
    
    // Swapping random pivot to first, making that as pivot for normal quicksort algo
    int temp = arr[p];
    arr[p] = arr[i];
    arr[i] = temp;
    
    return partition(arr, p, r);
  }
  
  public static void main(String [] args)
  {
    Scanner read = new Scanner(System.in);
    
    int n = read.nextInt();
    int [] arr = new int[n];
    
    for(int i = 0; i<n; i++)
    {
      arr[i] = read.nextInt();
    }
    
    // We at first take first element to be pivot, then change it to the middle
    quicksort(arr, 0, n-1);
    for(int i = 0; i<n; i++)
    {
      System.out.println(arr[i]);
    }
  }
}