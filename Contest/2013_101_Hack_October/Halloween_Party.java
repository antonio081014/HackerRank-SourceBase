import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Antonio081014
 * @since Nov 2, 2013, 10:32:23 AM
 */
public class Solution {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int T = Integer.parseInt(in.readLine());
			while (T-- > 0) {
				int K = Integer.parseInt(in.readLine());
				long max = 0;
				for (long i = 1, j = K - 1; i <= j; i++, j--)
					max = Math.max(max, i * j);
				System.out.println(max);
				// System.out.println(Integer.MAX_VALUE);
			}
		} catch (Exception e) {
		}

	}

}
