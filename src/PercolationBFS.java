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
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 1};
		//Assignment description says to dequeue the cell??
//		for (int i = 0; i < deltaR.length; i++) {
//			if (inBounds(row+deltaR[i], col+deltaC[i]) && 
//				isOpen(row+deltaR[i], col+deltaC[i])) {
//					if (!connected.contains((row+deltaR[i])*myGrid.length + col+deltaC[i]))
//						connected.add((row+deltaR[i])*myGrid.length + col+deltaC[i]);
//			}
//		}
		
		 while (connected.size() != 0){
			 int[] cell = {connected.peek()/myGrid.length, connected.remove()%myGrid.length};
			 for(int k = 0; k < deltaR.length; k++){
				 row = cell[0] + deltaR[k];
				 col = cell[1] + deltaC[k];
				 if (inBounds(row,col) && isOpen(row, col)){
					 connected.add(row*myGrid.length + col);
				 }
			 }
		 }
	}
}