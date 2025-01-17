//Written by Shagoto
import java.util.*;
public class MaximumElement
{
  public static void main(String[]args)
  {
    Scanner read = new Scanner(System.in); 
    
    Stack<Integer> arr = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    temp.push(0);
    int t = read.nextInt();
    for(int x = 1; x<=t; x++)
    {
      int q = read.nextInt();
      
      if(q == 1)
      {
        int num = read.nextInt();
        arr.push(num);
        int max = temp.peek();
        
        if(num > max)
        {
          temp.push(num);
        }
        else
        {
          temp.push(max);
        }
      }
      else if(q == 2)
      {
        arr.pop();
        temp.pop();
      }
      else
      {
        System.out.println(temp.peek());
      }
    }
  }
}