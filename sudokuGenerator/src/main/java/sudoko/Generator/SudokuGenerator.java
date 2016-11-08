
/**
* This Sudoku is a number-placement puzzle where every number 
* form 1 to 4 must be placed once, and once only, in every
* row, column and four 2x2 sub grids.
* 
*
* @author  Abebaw Azene Bitew
* @version 1.0
* @since   2016-11-08 
*/

package sudoko.Generator;
import java.util.*;

/**
*The SudokuGenerator class creates a random standard 4x4 grid
*
*/

public class SudokuGenerator {
	private final int size = 4;
	private int[][] grid;	
	
	   public SudokuGenerator() {
		   grid = new int[size][size];
	   }
		
		/**
		 *@param  noOfEmptyCells the number of empty squares
		 *@return grid
		 */
		public int[][] getGrid(double noOfEmptyCells)
		{
			grid = new int[size][size];
			double unexploredSquares = size*size;
			int[] values = {1,2,3,4};
			values = shuffleArray(values);
			nextSquare(0,0);
			
			for(int i=0;i<size;i++)
				for(int j=0;j<size;j++)
				{
					double hole = noOfEmptyCells/unexploredSquares;
					if(Math.random() <= hole)
					{
						grid[i][j] = 0;
						noOfEmptyCells--;
					}
					unexploredSquares--;
				}
			return grid;

		}
		
		/**
		 *This method puts a number to each square
		 *@param row row value of the current square
		 *@param column column value of the current square
		 *@return  true if the grid is filled or false on failure
		 */
		
		public boolean nextSquare(int row, int column)
		{
			int nextRow = row;
			int nextColumn = column;
			int[] values = {1,2,3,4};
			
			for(int i=0;i<size;i++)
			{
				if(isMovePossible(row, column, values[i]))
				{
					grid[row][column] = values[i];
					if(row == 3)
					{
						if(column == 3)
							return true;
						else
						{
							nextRow = 0;
							nextColumn = column + 1;
						}
					}
					else
					{
						nextRow = row + 1;
					}
					if(nextSquare(nextRow, nextColumn))
						return true;
				}
			}
			grid[row][column] = 0;
			return false;
		}
		
		
		/**
		 *This method returns true if the current number is not available in 
		 *the current row, cell or 2x2 squares otherwise returns false
		 *@param row row value of the current square
		 *@param column column value of the current square
		 *@param square The current value.
		 *@return true if move possible otherwise false
		 */
		private boolean isMovePossible(int row, int column, int square) {
			for(int i=0;i<size;i++) {
				if(square == grid[row][i])
					return false;
			}
			for(int i=0;i<size;i++) {
				if(square == grid[i][column])
					return false;
			}
			int endRow = 0;
			int endColumn = 0;
			if(row > 1)
				if(row > 3)
					endRow = 4;
				else
					endRow = 2;
			if(column > 1)
				if(column > 3)
					endColumn = 4;
				else
					endColumn = 2;
			for(int i=endRow;i<5 && i<endRow+2;i++)
				for(int j=endColumn;j<5 && j<endColumn+2;j++)
					if(square == grid[i][j])
						return false;
			return true;
		}
		
		/**
		 *This method shuffles our array
		 *@param array, the input array to be randomized.
		 *@return the randomized array
		 */
		public int[] shuffleArray(int[] array)
		{
		    int index, temp;
		    Random random = new Random();
		    for (int i = array.length - 1; i > 0; i--)
		    {
		        index = random.nextInt(i + 1);
		        temp = array[index];
		        array[index] = array[i];
		        array[i] = temp;
		    }
		    return array;
		}
		
		/**
		 *Prints the grid on the console
		 */
		public void show()
		{
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
					System.out.print(grid[i][j] + "  ");
				System.out.println();
			}
			System.out.println();
		}
		
		 /**
		   * This is the main method which makes use of getGrid & show methods
		   * @param args Unused
		   * @return Nothing
		   */
		public static void main(String[] args)
		{
			SudokuGenerator mysudoku = new SudokuGenerator();
			mysudoku.getGrid(10);
			mysudoku.show();
		}
		
}

