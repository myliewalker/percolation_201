import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
	public PercolationBFS(int n) {
		super(n);
	}

	@Override
	public void dfs (int row, int col) {
		if (! inBounds(row,col)) return;
		if (isFull(row, col) || !isOpen(row, col)) return;
		myGrid[row][col] = FULL;
		Queue<Integer> connected = new LinkedList<>();
		connected.add(row*myGrid.length + col);
		Queue<Integer> filled = new LinkedList<>();
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 1};
		while (connected.size() > 0){
			int[] cell = {connected.peek()/myGrid.length, connected.remove()%myGrid.length};
			for(int k = 0; k < deltaR.length; k++){
				row = cell[0] + deltaR[k];
				col = cell[1] + deltaC[k];
				if (inBounds(row,col) && isOpen(row, col)}
					if(isFull(row, col)){
						filled.add(row*myGrid.length + col);
					}
					else dfs(row, col);
				}
			}
		}
	}
}