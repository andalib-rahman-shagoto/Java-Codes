public class Task03
{
  public static void main(String[]args)
  {
    int [] a = new int[] {10, 30, 20, 50, 40};
    int max = 0;
    int maxIndex = 0;
    
    for(int i = 0; i<a.length; i++)
    {
      if(a[i] > max)
      {
        max = a[i];
        maxIndex = i;
      }
    }
    
    System.out.println("Largest number "+max);
    System.out.println("Location "+maxIndex);
  }
}