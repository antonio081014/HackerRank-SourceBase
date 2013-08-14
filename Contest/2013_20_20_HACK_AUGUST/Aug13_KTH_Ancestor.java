/**
 * The way I implement it is very simple and straight.
 * Just keep parent node for each node in the tree, while have each node in a list.
 * Then we could easily grab and search the kth Ancestor.
 * 
 * However, this algorithm seems not fast enough. Fails on the set of large data.
 * My Algorithm: O(Q * K) => O(10^10).
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Antonio081014
 * @since Aug 3, 2013, 11:17:19 AM
 */
public class Solution {

	private static final int SIZE = 100000;

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
				int P = Integer.parseInt(in.readLine());
				TreeNode[] tree = new TreeNode[SIZE + 1];
				tree[0] = new TreeNode(0);
				for (int i = 0; i < P; i++) {
					String[] s = in.readLine().split("\\s");
					int b = Integer.parseInt(s[0]);
					int a = Integer.parseInt(s[1]);
					if (tree[b] == null)
						tree[b] = new TreeNode(b);
					if (tree[a] == null)
						tree[a] = new TreeNode(a);
					tree[b].parent = tree[a];
				}
				int Q = Integer.parseInt(in.readLine());
				for (int i = 0; i < Q; i++) {
					String[] s = in.readLine().split("\\s");
					switch (Integer.parseInt(s[0])) {
					case 0:
						int x = Integer.parseInt(s[1]);
						int y = Integer.parseInt(s[2]);
						if (tree[y] == null)
							tree[y] = new TreeNode(y);
						if (tree[x] == null)
							tree[x] = new TreeNode(x);
						tree[y].parent = tree[x];
						break;
					case 1:
						int z = Integer.parseInt(s[1]);
						tree[z] = null;
						break;
					case 2:
						int w = Integer.parseInt(s[1]);
						int k = Integer.parseInt(s[2]);
						if (tree[w] == null)
							System.out.println(0);
						else {
							TreeNode kthNode = tree[w].kthAncestor(k);
							if (kthNode == null)
								System.out.println(0);
							else
								System.out.println(kthNode.data);
						}
						break;
					default:
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class TreeNode {
	public int data;
	public TreeNode parent;

	public TreeNode(int d) {
		this.data = d;
		parent = this;
	}

	public TreeNode kthAncestor(int kth) {
		TreeNode current = this;
		while (current.parent != current && kth > 0) {
			current = current.parent;
			kth--;
			if (current == null)
				return null;
		}
		return current;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (data != other.data)
			return false;
		return true;
	}

}
