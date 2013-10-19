/**
 * 
 */
import java.util.Scanner;

/**
 * @author Antonio081014
 * @since Oct 19, 2013, 10:16:20 AM
 */
public class Solution {

	public static void main(String[] args) {
		Solution main = new Solution();
		main.run();
		System.exit(0);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int C = sc.nextInt();
			int M = sc.nextInt();
			int total = N / C;
			int wraps = N / C;
			while (wraps >= M) {
				total += wraps / M;
				wraps = wraps / M + wraps % M;
			}
			System.out.println(total);
		}
	}

}
