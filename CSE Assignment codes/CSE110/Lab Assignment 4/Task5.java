import java.util.Scanner;
public class Task5
{
  public static void main(String[]args)
  {
    Scanner read = new Scanner (System.in);
    
    int num;
    int i;
    for(i=1; i<=20; i=i+1)
    {
      System.out.println("Enter number");
      num = read.nextInt();
      
      if(num % 2 == 0)
      {
        System.out.println("Even");
      }
      
      else
      {
        System.out.println("Odd");
      }
    }
  }
}