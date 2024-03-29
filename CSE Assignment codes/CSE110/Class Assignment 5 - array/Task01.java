public class Task01
{
  public static void main(String[]args)
  { 
    int [] marks = new int[] {10, 30, 20, 50, 40};
    int max = marks[0];
    int min = marks[0];
    int sum = marks[0];
    
    for(int i = 1; i<5; i++)
    {
      if(marks[i] > max)
      {
        max = marks[i];
      }
      
      if(marks[i] < min)
      {
        min = marks[i];
      }
      
      sum += marks[i];
    }
    
    System.out.println("Highest mark is "+max);
    System.out.println("Lowest mark is "+min);
    System.out.println("Average mark is "+sum/5);
  }
}