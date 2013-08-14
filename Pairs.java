import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author antonio081014
 * @time: Oct 6, 2012, 2:32:58 PM
 */
public class Solution {

    private int K;

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	Solution main = new Solution();
	main.run();
	System.exit(0);
    }

    public void run() throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] str = br.readLine().split("\\s");
	int N = Integer.parseInt(str[0]);
	K = Integer.parseInt(str[1]);
	int[] array = new int[N];
	str = br.readLine().split("\\s");
	for (int i = 0; i < N; i++)
	    array[i] = Integer.parseInt(str[i]);

	Arrays.sort(array);
	int count = 0;
	for (int i = 0; i < N; i++) {
	    count += binaryLeft(0, i - 1, array, i);
	    count += binaryRight(i + 1, N - 1, array, i);
	}
	System.out.println(count / 2);
    }

    private int binaryLeft(int low, int high, int[] array, int index) {
	while (low <= high) {
	    int mid = (low + high) / 2;
	    if (array[mid] + K == array[index]) {
		// System.out.println("" + array[index] + " " + array[mid]);
		return 1;
	    } else if (array[mid] + K < array[index])
		low = mid + 1;
	    else
		high = mid - 1;
	}
	return 0;
    }

    private int binaryRight(int low, int high, int[] array, int index) {
	while (low <= high) {
	    int mid = (low + high) / 2;
	    if (array[mid] - K == array[index]) {
		// System.out.println("" + array[index] + " " + array[mid]);
		return 1;
	    } else if (array[mid] - K < array[index])
		low = mid + 1;
	    else
		high = mid - 1;
	}
	return 0;
    }

}

