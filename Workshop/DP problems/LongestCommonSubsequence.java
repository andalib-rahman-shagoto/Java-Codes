import java.util.*;
public class LongestCommonSubsequence
{
  public static void main(String [] args)
  {
    Scanner read = new Scanner(System.in);
    
    char [] x = read.nextLine().toCharArray();
    char [] y = read.nextLine().toCharArray();
    int x_len = x.length;
    int y_len = y.length;
    
    int [][] cost = new int[x_len+1][y_len+1];
    String [][] direction = new String[x_len+1][y_len+1];
    
    for(int i = 0; i<x_len+1; i++)
    {
      cost[i][0] = 0;
      direction[i][0] = "";
    }
    
    for(int i = 0; i<y_len+1; i++)
    {
      cost[0][i] = 0;
      direction[0][i] = "";
    }
    
    for(int i = 1; i<x_len+1; i++)
    {
      for(int j = 1; j<y_len+1; j++)
      {
        if(x[i-1] == y[j-1])
        {
          cost[i][j] = cost[i-1][j-1] + 1;
          direction[i][j] = "diagonal";
        }
        
        else if(cost[i-1][j] >= cost[i][j-1])
        {
          cost[i][j] = cost[i-1][j];
          direction[i][j] = "up";
        }
        
        else
        {
          cost[i][j] = cost[i][j-1];
          direction[i][j] = "left";
        }
      }
    }
    
    for(int i = 0; i<=x_len; i++)
    {
      for(int j = 0; j<=y_len; j++)
      {
        System.out.print(direction[i][j] + " ");
      }
      System.out.println();
    }
    
    System.out.println("Longest Common: "+cost[x_len][y_len]);
  }
}