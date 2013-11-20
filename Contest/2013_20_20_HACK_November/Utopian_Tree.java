import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Antonio081014
 * @since Nov 20, 2013, 10:36:45 AM
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
				int N = Integer.parseInt(in.readLine());
				long init = 1;
				for (int i = 1; i <= N; i++) {
					if (i % 2 == 1)
						init *= 2;
					else
						init++;
				}
				System.out.println(init);
			}
		} catch (Exception e) {
		}
	}

}
