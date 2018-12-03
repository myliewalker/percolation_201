
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);		
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 1};
		for (int i = 0; i < deltaR.length; i++) {
			if (row == 0 || (inBounds(row+deltaR[i], col+deltaC[i]) && 
				isFull(row+deltaR[i], col+deltaC[i]))) {
					dfs(row, col);
					return;
			}
		}
	}
}
