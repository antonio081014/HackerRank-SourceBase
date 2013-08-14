/**
 * This problem asks categorized each astronaut into right country they represent. 
 * I use Union-Find to categorize them.
 * 
 * Then, we have count[i], the number of astronauts represent ith country.
 * So the number of answer is to choose any two of these countries, 
 * have one astronaut from each to go to the moon. 
 * Then, we have answer = ∑count[i] * count[j], here i != j;
 * answer = ∑count[i] * (N - count[i])
 * 		  = N*∑count[i] - ∑count[i]*count[i]
 * 		  = N*N - ∑count[i]*count[i].
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author antonio081014
 * @time Aug 2, 2013, 9:02:03 PM
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
			String[] s = in.readLine().split("\\s");
			int N = Integer.parseInt(s[0]);
			int I = Integer.parseInt(s[1]);
			UnionFind uf = new UnionFind(N);
			while (I-- > 0) {
				s = in.readLine().split("\\s");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				uf.union(a, b);
			}
			long[] count = new long[N];
			for (int i = 0; i < N; i++) {
				count[uf.find(i)]++;
			}
			long ret = 0;
			for (int i = 0; i < N; i++) {
				// if (count[i] != 0)
				ret += count[i] * count[i];
			}
			// PS: we might lose the precision here is we do not convert N to
			// long, since N*N could be very large.
			System.out.println(((long) N * N - ret) / 2);
		} catch (Exception e) {
		}
	}
}

class UnionFind {
	public int N;
	public int[] parent;

	public UnionFind(int n) {
		this.N = n;
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public void union(int x, int y) {
		int r1 = find(x);
		int r2 = find(y);
		if (r1 == r2)
			return;
		parent[r1] = r2;
	}
}
