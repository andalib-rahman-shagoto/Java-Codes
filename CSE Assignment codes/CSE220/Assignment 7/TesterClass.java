// Lab Assignment 7
// Andalib Rahman Shagoto
// Section - 11
// 20101195
import java.util.*;
public class TesterClass
{
  public static void main(String [] args)
  {
    Scanner read = new Scanner(System.in);
    
    // ------------- Task 1 -------------
    int [] task1 = {2, 4, 1, 5, -4, 0, 10, 5, 2, 2, -1, -3, -4};
    KeyIndex ki = new KeyIndex(task1);
    int [] sorted_arr = ki.sort();
    for(int i = 0; i<sorted_arr.length; i++)
    {
      System.out.print(sorted_arr[i]+" ");
    }
    System.out.println();
    
    // ------------- Task 2 -------------
    String [] task2 = {};
    HashTable ht = new HashTable();
    // Pass strings in Hash Functions
    // E.g. ht.hashFunc("")
    ht.hashFunc("ST1E89B8A32");
    for(int i = 0; i<ht.table.length; i++)
    {
      System.out.print(ht.table[i]+" ");
    }
    System.out.println();
    
  }
}


// --------------------- Task 1 ---------------------
class KeyIndex
{
  int [] k;
  int min = 10000000;
  
  // ---------------- Constructor ----------------
  public KeyIndex(int [] a)
  {
    int max = -10000000;
    for(int i = 0; i<a.length; i++)
    {
      if(a[i] < min)
      {
        min = a[i];
      }
      else if(a[i] > max)
      {
        max = a[i];
      }
    }
    
    if(min <= 0)
    {
      int tempMin = min * -1;
      
      for(int i = 0; i<a.length; i++)
      {
        a[i] += tempMin;
        
        if(a[i] > max)
        {
          max = a[i];
        }
      }
    }
    
    k = new int[max+1];
    for(int i = 0; i<a.length; i++)
    {
      k[a[i]]++;
    }
  }
  
  // ---------------- Searching ----------------
  public boolean search(int val)
  {
    if(min <= 0)
    {
      val += min * -1;
    }
    
    if(val < 0 || val >= k.length)
    {
      return false;
    }
    
    if(k[val] > 0)
    {
      return true;
    }
    
    return false;
  }
  
  // ---------------- Sorting ----------------
  public int [] sort()
  {
    int count = 0;
    for(int i = 0; i<k.length; i++)
    {
      count += k[i];
    }
    
    int [] sorted = new int[count];
    int index = 0;
    for(int i = 0; i<k.length; i++)
    {
      for(int j = 1; j<=k[i]; j++)
      {
        if(min <= 0)
        {
          sorted[index++] = min + i;
        }
        else
        {
          sorted[index++] = i;
        }
      }
    }
    return sorted;
  }
}

// --------------------- Task 2 ---------------------
class HashTable
{
  String [] table;
  
  public HashTable()
  {
    table = new String[9];
  }
  
  // ---------------- Hash Function ----------------
  public void hashFunc(String s)
  {
    int consCount = 0;
    int sum = 0;
    
    for(int i = 0; i<s.length(); i++)
    {
      if(s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U' && (int)s.charAt(i) >= 65)
      {
        consCount++;
      }
      else if(s.charAt(i) == '0')
      {
        sum += 0;
      }
      else if(s.charAt(i) == '1')
      {
        sum += 1;
      }
      else if(s.charAt(i) == '2')
      {
        sum += 2;
      }
      else if(s.charAt(i) == '3')
      {
        sum += 3;
      }
      else if(s.charAt(i) == '4')
      {
        sum += 4;
      }
      else if(s.charAt(i) == '5')
      {
        sum += 5;
      }
      else if(s.charAt(i) == '6')
      {
        sum += 6;
      }
      else if(s.charAt(i) == '7')
      {
        sum += 7;
      }
      else if(s.charAt(i) == '8')
      {
        sum += 8;
      }
      else if(s.charAt(i) == '9')
      {
        sum += 9;
      }
    }
    
    int index = (consCount * 24 + sum) % 9;
    if(table[index] == null)
    {
      table[index] = s;
    }
    else
    {
      linearProbing(s, index);
    }
  }
  
  // ---------------- Linear Probing ----------------
  public void linearProbing(String s, int index)
  {
    while(table[index] != null)
    {
      index++;
      index %= 9;
    }
    
    table[index] = s;
  }
}