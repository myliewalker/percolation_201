
public class PercolationUF implements IPercolate{

	private boolean[][] myGrid;
	private int myOpenCount;
	private IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;

	public PercolationUF (int size, IUnionFind finder) {
		myGrid = new boolean[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				myGrid[r][c] = false;
			}
		}
		myOpenCount = 0;
		finder.initialize(size*size+2);
		myFinder = finder;
		VTOP = size*size;
		VBOTTOM = size*size+1;
	}

	@Override
	public void open(int row, int col) {
		if (! inBounds(row, col) || row*row+col < 0) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (isOpen(row, col)) return;
		myGrid[row][col] = true;
		if (row == 0) myFinder.union(VTOP, row*myGrid.length + col);
		if (row == myGrid.length-1) myFinder.union(VBOTTOM, row*myGrid.length + col);
		int[] deltaR = {-1, 1, 0, 0};
		int[] deltaC = {0, 0, -1, 1};
		for (int i = 0; i < deltaR.length; i++) {
			if (inBounds(row+deltaR[i], col+deltaC[i]) && isOpen(row+deltaR[i], col+deltaC[i])) {
				myFinder.union((row+deltaR[i])*(myGrid.length) + col+deltaC[i], row*myGrid.length + col);
			}
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myFinder.connected(VTOP, row*myGrid.length + col);
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	public boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
}
