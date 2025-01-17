import java.util.*;
public class RecursiveBubbleSort
{
  static int [] bs(int [] arr, int l)
  {
    if(l == 0)
    {
      return arr;
    }
    
    for(int i = 0; i<l; i++)
    {
      if(arr[i] > arr[i+1])
      {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
      }
    }
    
    return bs(arr, l-1);
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
    
    int [] sorted = bs(arr, n-1);
    for(int i = 0; i<n; i++)
    {
      System.out.print(sorted[i]+" ");
    }
    System.out.println();
  }
}