/**
 * Harvey Specter has agreed to take Mike Ross to a meeting with NSA filled with brilliant scientists. But, as always, its not going to be easy for Mike. He has to solve a puzzle given by Harvey.

 * Harvey gives two numbers N and K and defines a set A.

 * A = { x : x is a natural number ≤ N }
 * (i.e), A = {1,2,3,4,5,6,…., N}

 * Mike has to find the total number of pairs of elements A[i] and A[j] belonging to the given set such that i < j and their sum is divisible by K

 * Input Format
 * An integer T followed by T lines, each containing a pair of integers N and K separated by a single space.

 * Output Format
 * T integers on separate lines each corresponding to the answer to that test case.

 * Constraints
 * 1<=T<=100
 * K<=N<=10^9 
 * 1<=K<=10000

 * Sample Input

 * 2
 * 10 4
 * 7 3
 * Sample Output

 * 10
 * 7
 * Explanation

 * For the 1st test case, there are 10 pairs whose sum is divisible by 4. 
 * (1,3), (1,7), (2,6), (2,10), (3,5), (3,9), (4,8), (5,7), (6,10) and (7,9)

 * For the 2nd test case, there are 7 pairs whose sum is divisible by 3. 
 * (1,2), (1,5), (2,4), (2,7), (3,6), (4,5) and (5,7)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Antonio081014
 * @since Sep 9, 2013, 11:50:41 AM
 */
public class Solution {

	public static void main(String[] args) {
		Solution main = new Solution();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int T = Integer.parseInt(in.readLine());
			while (T-- > 0) {
				String[] str = in.readLine().split("\\s");
				long N = Long.parseLong(str[0]);
				long K = Long.parseLong(str[1]);
				System.out.println(solve(N, (int) K));
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Categorization: Find the number of natural numbers from 1 to N which mods
	 * to 0 to K-1;<br />
	 * Pair: find the two category which adds up to be K<br />
	 * Two cases need to be taken care: 1, two category are the same; 2, two
	 * category are different; <br />
	 * 
	 * Time: O(K) <br />
	 * Space: O(K) <br />
	 * */
	private long solve(long N, int K) {
		long[] count = new long[K + 1];
		for (int i = 1; i <= K; i++) {
			count[i] = (N - i) / K + 1;
		}
		count[0] = count[K];
		long sum = 0;
		for (int i = 0; i <= K / 2; i++) {
			int a = i % K;
			int b = (K - a) % K;
			if (a == b) {
				sum += count[a] * (count[b] - 1) / 2;
			} else {
				sum += count[a] * count[b];
			}
		}
		return sum;
	}

	/**
	 * Go through each number from 1 to N; For each number(call it A), find the
	 * number of natural numbers in the set could pair with A, whose sum will
	 * mod by K to be zero;
	 * 
	 * Time: O(N) <br />
	 * Space: O(Constant)<br />
	 */
	private long solve1(long N, long K) {
		long sum = 0;
		for (long i = 1; i <= N; i++) {
			long a = (i / K) * K + K - i % K;
			if (a <= i)
				a += K;
			// System.out.println(String.format("%d %d", i, a));
			if (a <= N)
				sum += (int) ((N - a) / K) + 1;
		}
		return sum;
	}
}
