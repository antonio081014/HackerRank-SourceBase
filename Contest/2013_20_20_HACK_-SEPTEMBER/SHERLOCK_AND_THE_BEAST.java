/**
 * Contests 20/20 Hack September
 * Sherlock and The Beast
 * Sherlock Holmes is getting paranoid about Professor Moriairty, his archenemy. All his efforts to subdue Moriarty have been in vain. These days Sherlock is working on the conversation he had with Dr. Watson. Watson mentioned that the CIA have been having weird problems with their supercomputer ‘The Beast’ recently.

 * This afternoon, Shelock received a note from Moriarty, saying he has infected ‘The Beast’ with a virus. In addition the note had the number ‘k’ printed on it. After doing some calculations, Sherlock found out that the key to remove the virus is the largest ‘Decent’ Number having ‘k’ digits.

 * A ‘Decent’ Number has -
 *1. Only 3 and 5 as its digits.
 *2. Number of times 3 appears is divisible by 5.
 *3. Number of times 5 appears is divisible by 3.

 *Meanwhile, the counter to destruction of ‘The Beast’ is running very fast. Can you save ‘The Beast’ and find the key before Sherlock?

 *Input Format
 *1st line will contain an integer T, the number of test cases, followed by T lines, each line containing an integer N i.e. the number of digits in the number 

 *Output Format
 *Largest Decent number having N digits. If no such number exists, you tell Sherlock that he is wrong and print ‘-1’ 

 *Constraints
 *1<=T<=20
 *1<=N<=100000


 *Sample Input
 *4
 *1
 *3
 *5
 *11
 
 *Sample Output
 *-1
 *555
 *33333
 *55555533333
 
 *Explanation
 *For N=1 , there is no such number. 
 *for N=3, 555 is only possible number.
 *For N=5, 33333 is only possible number.
 *For N=11 , 55555533333 and all of permutations of digits are valid numbers, among them, the given number is the largest one.
 * 
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Antonio081014
 * @since Sep 9, 2013, 10:22:40 AM
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
				System.out.println(solve(N));
			}
		} catch (Exception E) {
		}
	}

	/**
	 * Get the largest possible string compose of only 3s and 5s in N digits.<br />
	 * Lesson: <br />
	 * The Java String Concatenation Operator '+' is implemented by using
	 * StringBuffer class. Thus, every time this operator been used, the VM will
	 * allocate new memory for new StringBuilder instance, append the string to
	 * the original one, then return the new one as a string.<br />
	 * So if a function is heavily implemented with + string operators, it's
	 * better to use StringBuilder directly, then return the resulted string.
	 * 
	 * This function cost:<br />
	 * Time: O(N); <br />
	 * Space: O(Constant);<br />
	 * */
	private String solve(int N) {
		for (int i = 0; i * 5 <= N; i++) {
			if ((N - i * 5) % 3 == 0) {
				StringBuilder ret = new StringBuilder();
				int a = (N - i * 5) / 3;
				for (int j = 0; j < a; j++) {
					ret.append("555");
				}
				for (int j = 0; j < i; j++)
					ret.append("33333");
				return ret.toString();
			}
		}
		return "-1";
	}
}
