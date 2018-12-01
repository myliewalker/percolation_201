
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);		
	}
	
	@Override
	public void updateOnOpen(int row, int col) {
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 0};
		if (row == 0) {
			dfs(row, col);
			return;
		}
		for (int i = 0; i < deltaR.length; i++) {
			if (inBounds(row+deltaR[i], col+deltaC[i]) && 
				isFull(row+deltaR[i], col+deltaC[i])) {
					dfs(row, col);
					break;
			}
		}
	}
}
