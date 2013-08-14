import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author antonio081014
 * @time Oct 6, 2012, 11:57:39 PM
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		Solution main = new Solution();
		main.run();
		System.exit(0);
	}

	public void run() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		str = br.readLine().split("\\s");
		int[] cost = new int[N];
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(cost);
		int total = 0;
		int _K, i;
		for (i = N - 1, _K = K; i >= 0 && _K > 0; i--, _K--) {
			total += cost[i];
		}
		int index = 0;
		int round = 1;
		for (; i >= 0; i--) {
			total += cost[i] * (round + 1);
			index++;
			if (index >= K) {
				round++;
				index = 0;
			}
		}
		System.out.println(total);
	}
}

