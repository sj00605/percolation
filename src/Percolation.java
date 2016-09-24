import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	
	public int[][] grid;
	public int size;
	
	/*
	 * 1 means full
	 * 0 means open
	 */
	public Percolation(int n){
		
		size = n;
		grid = new int[n][n];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				grid[i][j] = 1;
			}
		}
		
	}
	
	public void open(int i, int j){
		grid[i][j] = 0;
	}
	
	public boolean isOpen(int i, int j){
		
		if()
		int site = grid[i][j];
		if(site == 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	public boolean isFull(int i, int j){
		
		int site = grid[i][j];
		if(site == 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	public boolean percolates(QuickFindUF qf){
		
		int j = grid[0].length - 1;
		int lastRow = grid.length - 1;
		for(int i=0; i<grid.length; i++){
			
			if(qf.connected(grid[i][0], grid[lastRow][j])){
				return true;
			}
		}
		
		return false;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		QuickFindUF qf = new QuickFindUF(n*n);
		Percolation perc = new Percolation(n);
		int count = 0;
		
		while(!perc.percolates(qf) || count<(n*n)){
			
			//Generate Random Number
			int i = StdRandom.uniform(0,n);
			int j = StdRandom.uniform(0,n);
			System.out.println("i= " + i + " j= " + j);
			
			//Open random site
			perc.open(i, j);
			
			//Quick Find
			int p = n * i + j + 1;
			//Check for openings surrounding the new open site
			//check above
			if(perc.isOpen(i--, j)){
				
				int q = n * (i-1) + j + 1;
				qf.union(p, q);
			}
			
			//check below
			if(perc.isOpen(i, j++)){
				
				int q = n * i + (j+1) + 1;
				qf.union(p, q);
			}
			
			//check left
			if(perc.isOpen(i, j--)){
				
				int q = n * i + (j-1) + 1;
				qf.union(p, q);
			}
			
			//check right
			if(perc.isOpen(i++, j)){
				
				int q = n * (i++) + j + 1;
				qf.union(p, q);
			}
			
			
			//increment count
			count++;
			
		}
		
	}

}
