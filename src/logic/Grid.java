package logic;

import java.util.*;

public class Grid {

	public static void main(String[] args) {
		System.out.println(krakenCount(7,7)); //input any size 2D array you wish
	}
	    static int krakenCount(int m, int n) {
	       
	    	int krackenGrid[][] = new int[m][n];

	    	for (int i = 0; i < m; i++) {
	    		krackenGrid[i][0] = 1; //check 1 instead of 0 as it is start of column not matrix index
	    	}

	    	for (int j = 0; j < n; j++) {
	    		krackenGrid[0][j] = 1; //check 1 instead of 0 as it is start of row not matrix index
	    	}


	    	for (int i = 1; i < m; i++) {
	    		for (int j = 1; j < n; j++) {
	    			
	    			krackenGrid[i][j] = (int)   (krackenGrid[i-1][j] + //go right
	    										krackenGrid[i][j-1] + //go down
	    										krackenGrid[i-1][j-1]); //go diagonal
	    										
	    									// the position [1][1] has a value of 3
	    									//because there are 3 ways to reach that cell
	    									//the 3 ways are:
	    									//1. right then down 2. diagonal 3. down then right
	    		}
	    	}
	    	for (int[] arr : krackenGrid) {
	    	System.out.println(Arrays.toString(arr));
	    	}

	    	return krackenGrid[m-1][n-1]; 
	    }
}
 //the number of ways a particular cell can
//be reached is always the sum of the number
//of ways the cells above it, left of the and diagonal to it