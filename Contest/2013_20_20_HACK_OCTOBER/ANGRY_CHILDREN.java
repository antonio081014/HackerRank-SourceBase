/**
 * Firstly, I thougth it's more like a knapsack style dynamic programming, 
 * then I realize it's just a greedy one.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Antonio081014
 * @since Sat Oct 19 10:36:35 PDT 2013
 */
public class Solution {

	private int K;

	public static void main(String[] args) {
		Solution main = new Solution();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int N = Integer.parseInt(in.readLine());
			K = Integer.parseInt(in.readLine());
			int[] nums = new int[N];
			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(in.readLine());
			// System.out.println(minUnfairness(nums, 0, Integer.MIN_VALUE,
			// Integer.MAX_VALUE, 0));
			System.out.println(minUnfairness(nums));
		} catch (Exception e) {
		}
	}

	/**
	 * Great greedy solution.
	 * */
	private int minUnfairness(int[] num) {
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + K <= num.length; i++) {
			min = Math.min(min, num[i + K - 1] - num[i]);
		}
		return min;
	}

	/**
	 * Knapsack solution;
	 * */
	private int minUnfairness(int[] num, int current, int max, int min,
			int count) {
		if (count == K) {
			return max - min;
		}
		int ret = minUnfairness(num, current + 1, Math.max(max, num[current]),
				Math.min(min, num[current]), count + 1);
		if (num.length - current - 1 >= K - count) {
			ret = Math.min(ret,
					minUnfairness(num, current + 1, max, min, count));
		}
		return ret;
	}
}
