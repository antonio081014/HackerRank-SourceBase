import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String src = in.readLine();
		int[] count = count(src);
		int odd = 0;
		for (int i = 0; i < 26; i++)
			if (count[i] % 2 != 0)
				odd++;

		int len = (src.length() - odd) / 2;
		// createTable(len);
		// print(table);
		long ret = 1;
		for (int i = 0; i < 26; i++) {
			count[i] /= 2;
			if (count[i] * 2 > len)
				ret *= C(len, len - count[i]);// table[len][len - count[i]];
			else
				ret *= C(len, count[i]);// table[len][count[i]];
			ret %= MOD;
			len -= count[i];
		}
		System.out.println(ret);
	}

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++)
				System.out
						.print(String.format("(%d,%d):%d", i, j, array[i][j]));
			System.out.println();
		}
	}

	private static int[][] table;

	private static long C(int n, int k) {
		long nom = 1;
		long dem = 1;
		for (int i = 0; i < k; i++) {
			nom = (nom * (n - i)) % MOD;
			dem = (dem * (i + 1)) % MOD;
		}
		return (nom * BigInteger.valueOf(dem)
				.modInverse(BigInteger.valueOf(MOD)).longValue())
				% MOD;
	}

	private static void createTable(int size) {
		table = new int[size + 1][(size + 2) / 2];
		for (int i = 0; i <= size; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= size; i++)
			for (int j = 1; j <= i / 2; j++) {
				long a = (long) table[i - 1][j];
				if (j * 2 > i - 1)
					a = (long) table[i - 1][i - 1 - j];
				long b = (long) table[i - 1][j - 1];
				if (2 * j - 2 > i - 1)
					b = (long) table[i - 1][i - j];
				table[i][j] = (int) ((a + b) % MOD);
			}
	}

	private static int[] count(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		return count;
	}
}
