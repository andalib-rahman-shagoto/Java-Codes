import java.util.Scanner;
public class Task7
{
  public static void main(String[]args)
  {
    Scanner read = new Scanner (System.in);
    
    System.out.println("Enter quantity");
    int quantity = read.nextInt();
    System.out.println("Enter number");
    int num = read.nextInt();
    
    int total = num;
    int min = num;
    int max = num;
   // quantity = quantity - 1;
    
    int i;
    for(i=2; i<=quantity; i=i+1)
      {
         System.out.println("Enter number");
         int num2 = read.nextInt();
         
         total = total + num;
         if(num2 > max)
         {
           max = num2;
         }
         
         if(num2 < min)
         {
           min = num2;
         }
      }
   // quantity = quantity + 1;
    
    System.out.println("Average = "+(total/quantity));
    System.out.println("Maximum = "+max);
    System.out.println("Minimum = "+min);
  }
}