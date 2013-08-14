import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem: 2's complement, from interviewStreet.
 * 
 * The solution is from the link, which reached a log(n) time complexity on this
 * one.
 */

/**
 * @author antonio081014
 * @since Jan 5, 2012, 1:41:35 PM
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(
        // new DataInputStream(new FileInputStream(args[0]))));
        // BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            System.out.println(solve(a, b));
            // bw.write(Long.toString(solve(a, b)) + "\n");
        }
        br.close();
        // bw.close();
    }

    /**
     * http://stackoverflow.com/questions/7942732/number-of-1s-in-the-twos-
     * complement-binary-representations-of-integers-in-a-ran
     * 
     * The explanation greatly explans everything.
     * 
     * */
    public static long solve(int a, int b) {
        if (a >= 0) {
            long ret = counter(b);
            if (a > 0)
                ret -= counter(a - 1);
            return ret;
        }
        long ret = ((long) 32 * (-(long) a)) - counter(-a - 1);
        if (b > 0)
            ret += counter(b);
        else if (b < -1) {
            b++;
            ret -= ((long) 32 * (-(long) b)) - counter(-b - 1);
        }
        return ret;
    }

    /**
     * Calculate the number of 1s from number 0 to number num;
     * 
     * */
    public static long counter(int num) {
        if (num == 0)
            return 0L;
        if (num % 2 == 0)
            return counter(num - 1) + ones(num);
        return (((long) num + 1) / 2) + 2 * counter(num / 2);
    }

    /**
     * Calculate the number of 1s in the number
     */
    public static long ones(int num) {
        String str = Integer.toBinaryString(num);
        long sum = 0L;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '1')
                sum++;
        return sum;
    }
}
