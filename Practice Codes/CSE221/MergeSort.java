import java.util.*;
public class MergeSort
{
  static int [] merge(int [] a, int [] b)
  {
    int n1 = a.length;
    int n2 = b.length;
    int [] c = new int[n1 + n2]; // new array (merged)
    
    int left = 0; // pointer for a
    int right = 0; // pointer for b
    int ind = 0; // pointer for c
    
    while(left < n1 || right < n2)
    {
      count++;
      if(left == n1) // left one done but right remaining
      {
        c[ind] = b[right];
        ind++;
        right++;
        continue;
      }
      
      if(right == n2) // right one done but left remaining
      {
        c[ind] = a[left];
        ind++;
        left++;
        continue;
      }
      
      // Pushing elements by comapring with two pointers
      if(a[left] <= b[right])
      {
        c[ind] = a[left];
        ind++;
        left++;
      }
      else
      {
        c[ind] = b[right];
        ind++;
        right++;
      }
    }
    
    return c; // Returning merged (sorted) array
  }
  
  static int [] mergesort(int [] arr)
  {
    if(arr.length == 1) // Single Element (Base case)
    {
      return arr;
    }
    else
    {
      int [] arr1 = mergesort(Arrays.copyOfRange(arr, 0, arr.length/2));
      int [] arr2 = mergesort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
      // Sending two unsorted array to merge
      // I am getting a merged sorted array from merge(arr1, arr2)
      return merge(arr1, arr2); // Returning the merged sorted array
    }
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
    
    int [] sort = mergesort(arr);
    for(int i = 0; i<n; i++)
    {
      System.out.println(sort[i]);
    }
  }
}