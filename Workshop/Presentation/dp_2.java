import java.io.BufferedOutputStream;
import java.io.PrintWriter;

//**Todo: Implement O(n^2) dp with O(n) space optimized for both**
public class dp_2 {
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    static final String test = "abc";

    public static void main(String[] args) {
        pw.println(give_me_minimum_partition(test));
        pw.close();
    }

    static int give_me_minimum_partition(String s) {
        //Todo: at most we will need n - 1 cut's for a String of length n
        int[] partition_count = new int[s.length()];
        for (int i = 0; i < partition_count.length; i++) {
            partition_count[i] = i;
        }
        for (int i = 1; i < s.length(); i++) {
            int mid_index = i, end_index = i;
            //Todo: When the substring length is odd
            while (mid_index >= 0 && end_index < s.length() && s.charAt(mid_index) == s.charAt(end_index)) {
                int new_partition_number = mid_index != 0 ? partition_count[mid_index - 1] + 1 : 0;
                partition_count[end_index] = Integer.min(partition_count[end_index], new_partition_number);
                mid_index--;
                end_index++;
            }
            //Todo: when the length of the substring is even**
            mid_index = i - 1;
            end_index = i;//Todo: end_index = i is reducible just again initializing for better understanding
            while (mid_index >= 0 && end_index < s.length() && s.charAt(mid_index) == s.charAt(end_index)) {
                int new_partition_number = mid_index != 0 ? partition_count[mid_index - 1] + 1 : 0;
                partition_count[end_index] = Integer.min(partition_count[end_index], new_partition_number);
                mid_index--;
                end_index++;
            }

        }
        return partition_count[s.length() - 1];
    }
}