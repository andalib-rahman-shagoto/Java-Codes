import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//Todo: Implement Min cuts.
public class Recursive_Approach {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


    public static void main(String[] args) {
        String test = "bbba";
        int count = give_min_partition(0, test.length() - 1, test);
        pw.println(count);
        pw.close();
    }

    static boolean isPalindrome(int i, int j, String check) {
        char[] arr = check.toCharArray();
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    //Todo: May want to change it long depending on the problem.
    static int give_min_partition(int i, int j, String s) {
      
        if (i >= j || isPalindrome(i, j, s)) {
            return 0;
        }
        int count = (int) 1e9, cur_count;
        for (int whatever = i; whatever < j; whatever++) {
          System.out.println("Parting: "+s.substring(i, whatever+1)+" "+s.substring(whatever+1, j+1));
            cur_count = give_min_partition(i, whatever, s) + give_min_partition(whatever + 1, j, s);
            cur_count++;
            count = Integer.min(cur_count, count);
        }
        
        return count;
    }
}