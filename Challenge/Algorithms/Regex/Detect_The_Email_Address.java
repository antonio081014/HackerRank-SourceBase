/**
 * HackerRank Algorithm -> Regex.
 * 
 * DETECT THE EMAIL ADDRESSES
 * 
 * using Regex
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Antonio081014
 * @since Sep 19, 2013, 3:46:51 PM
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
			HashSet<String> emails = new HashSet<String>();
			int N = Integer.parseInt(in.readLine());

			for (int i = 0; i < N; i++) {
				String[] s = in.readLine().split("\\s");
				for (int j = 0; j < s.length; j++) {
					// s[j] = s[j].replaceAll("[^a-zA-Z0-9@.]", "");
					if (isEmail(s[j])) {
						// s[j].replaceAll("(\\b)[\\W]*", "");
						s[j] = trans(s[j]);
						emails.add(s[j]);
					}
				}
			}
			ArrayList<String> list = new ArrayList<String>(emails);
			Collections.sort(list);
			System.out.print(list.get(0));
			for (int i = 1; i < list.size(); i++)
				System.out.print(";" + list.get(i));
			System.out.println();
		} catch (Exception e) {
		}
	}

	private boolean isEmail(String s) {
		// Start with a word
		// It could have _ or . between word
		// It must has one @
		// It must follow some word
		// It must has one . to separate domain.
		// It followed by domain.
		// It might has punctuation followed the email address. We'll remove it
		// later.
		Pattern pattern = Pattern
				.compile("^[\\w]+[\\w_.]*@(\\w)+.(\\w)+[\\W]*");
		// "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
		Matcher matcher = pattern.matcher(s);
		return matcher.find();
	}

	private String trans(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					|| (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				return s.substring(0, i + 1);
			} else {
				continue;
			}
		}
		return "";
	}
}
