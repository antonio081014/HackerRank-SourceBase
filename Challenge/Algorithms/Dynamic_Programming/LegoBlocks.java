/**
 * Apparently, this is a dynamic programming problem, but it's hard to
 * figure out the state formula at the first glance.<br />
 * 1st, calculate how many ways to construct N*i walls with "pieces" blocks.
 * as possibleColumnCombinations represented.<br />
 * 2nd, calculate how many ways to construct N*i solid walls, that would be
 * all possible way of construction subtract the ways of construct not solid.<br />
 * possibleColumnCombinationsSolid[i] = 
 * modSub(possibleColumnCombinationsSolid[i],
 * modMult(possibleColumnCombinationsSolid[j], possibleColumnCombinations[i - j]));<br />
 * Every j could be a vertical cutting line, which means the ways built before j has no problem, 
 * the cutting line is at j and the walls built after j could be anything alike. Just as formula states.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Antonio081014
 * @since Aug 13, 2013, 9:22:40 AM
 */
public class Solution {

	private long[] possibleRowCombinations;
	private long[] possibleColumnCombinations;
	private long[] possibleColumnCombinationsSolid;

	private static final int[] pieces = { 1, 2, 3, 4 };
	private static final int MOD = 1000000007;

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
				String[] s = in.readLine().split("\\s");
				int N = Integer.parseInt(s[0]);
				int M = Integer.parseInt(s[1]);
				System.out.println(getNumberOfWays(N, M));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long modAdd(long a, long b) {
		return (a + b) % MOD;
	}

	private long modMult(long a, long b) {
		return (a * b) % MOD;
	}

	private long modSub(long a, long b) {
		return (MOD + a - b) % MOD;
	}

	private long getNumberOfWays(int N, int M) {
		possibleRowCombinations = new long[M + 1];
		possibleColumnCombinations = new long[M + 1];
		possibleColumnCombinationsSolid = new long[M + 1];

		possibleRowCombinations[0] = 1;
		for (int i = 1; i <= M; i++)
			for (int j = 0; j < pieces.length; j++) {
				if (i >= pieces[j])
					possibleRowCombinations[i] = modAdd(
							possibleRowCombinations[i],
							possibleRowCombinations[i - pieces[j]]);
			}

		for (int i = 1; i <= M; i++) {
			long res = 1;
			for (int j = 1; j <= N; j++) {
				res = modMult(res, possibleRowCombinations[i]);
			}
			possibleColumnCombinations[i] = res;
		}

		// possibleColumnCombinationsSolid[1] =
		// possibleColumnCombinations[1];
		for (int i = 1; i <= M; i++) {
			possibleColumnCombinationsSolid[i] = possibleColumnCombinations[i];
			for (int j = 1; j < i; j++) {
				possibleColumnCombinationsSolid[i] = modSub(
						possibleColumnCombinationsSolid[i],
						modMult(possibleColumnCombinationsSolid[j],
								possibleColumnCombinations[i - j]));
			}
		}

		return possibleColumnCombinationsSolid[M];
	}
}
