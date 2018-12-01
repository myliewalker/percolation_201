
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);		
	}
	
	@Override
	public void updateOnOpen(int row, int col) {
//		if (row == 0) {
//			dfs(row, col);
//			return;
//		}
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 0};
		for (int i = 0; i < deltaR.length; i++) {
			if ((inBounds(row+deltaR[i], col+deltaC[i]) && 
				isFull(row+deltaR[i], col+deltaC[i])) || row == 0) {
					dfs(row, col);
//					break;
			}
		}
	}
}
