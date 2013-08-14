import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	Solution main = new Solution();
	main.run();
	System.exit(0);
    }

    private void run() {
	Scanner in = new Scanner(System.in);
	String s = in.next();
	int len = s.length();
	Rect rect = new Rect(len);
	int row = rect.row; // (int)Math.sqrt(1.0*len); //1;
	int col = rect.col; // (len+row-1) / row; //len;
	// System.out.println(row);
	// System.out.println(col);

	String ret = "";
	for (int start = 0; start < col; start++) {
	    for (int j = 0; j < row && start + j * col < len; j++) {
		ret += s.charAt(start + j * col);
	    }
	    ret += " ";
	}
	System.out.println(ret.substring(0, ret.length() - 1));
    }

    class Rect {
	public int row;
	public int col;

	public Rect(int area) {
	    int max = area;
	    int low = (int) Math.floor(Math.sqrt(area));
	    int high = (int) Math.ceil(Math.sqrt(area));
	    for (int r = low; r <= high; r++) {
		int c = (area + r - 1) / r;
		if (c < low || c > high)
		    continue;
		if (Math.abs(r * c - area) < max) {
		    row = Math.min(r, c);
		    col = Math.max(r, c);
		    max = Math.abs(r * c - area);
		}
	    }
	}
    }
}
