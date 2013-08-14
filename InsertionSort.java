import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This problem actually ask the coder to count the number of inversions.
 * The updated merge-sort could count this number perfectly.
 */

/**
 * @author antonio081014
 * @since Jan 8, 2012, 4:41:26 PM
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new InputStreamReader(
        // new DataInputStream(new FileInputStream("input.txt"))));
        // BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
        // "output.txt")));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                nums[j] = Integer.parseInt(strs[j]);
            System.out.println(Long.toString(sort_and_count(nums, 0, N - 1)));
            // bw.write(Long.toString(sort_and_count(nums, 0, N - 1)) + "\n");
        }
        // br.close();
        // bw.close();
    }

    public static long sort_and_count(int[] a, int x1, int x2) {
        if (x2 <= x1)
            return 0L;
        if (x2 == x1 + 1) {
            if (a[x1] > a[x2]) {
                a[x1] ^= a[x2];
                a[x2] ^= a[x1];
                a[x1] ^= a[x2];
                return 1L;
            }
            return 0L;
        }
        int mid = (x2 + x1) / 2;
        long count = 0L;
        count += sort_and_count(a, x1, mid);
        count += sort_and_count(a, mid + 1, x2);
        count += merge_and_count(a, x1, mid, mid + 1, x2);
        return count;
    }

    public static long merge_and_count(int[] a, int x1, int x2, int y1, int y2) {
        long count = 0L;
        for (int i = x1, j = y1; i <= x2 && j <= y2;) {
            if (a[i] > a[j]) {
                count += (long) (x2 - i + 1);
                j++;
            }
            else
                i++;
        }
        Arrays.sort(a, x1, y2 + 1);
        return count;
    }

    public static long insertSort(int[] a) {
        long count = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j >= 1 && a[j] < a[j - 1]) {
                a[j] ^= a[j - 1];
                a[j - 1] ^= a[j];
                a[j] ^= a[j - 1];
                count++;
                j--;
            }
        }
        return count;
    }
}
