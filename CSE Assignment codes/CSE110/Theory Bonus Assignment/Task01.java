import java.util.Scanner;
public class Task01
{
  public static void main(String[]args)
  {
    Scanner read = new Scanner (System.in);
    
    System.out.println("Enter first number");
    int x = read.nextInt();
    
    System.out.println("Enter second number");
    int y = read.nextInt();
    
    System.out.println("Enter third number");
    int z = read.nextInt();
    
    if(x < y)
    {
      if(x < z)
      {
        System.out.println(y*z);
      }
    }
    
    if(y < x)
    {
      if(y < z)
      {
        System.out.println(x*z);
      }
    }
    
    if(z < x)
    {
      if(z < y)
      {
        System.out.println(x*y);
      }
    }
  }
}