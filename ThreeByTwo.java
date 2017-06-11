package ACSL;

public class ThreeByTwo {

	final static int BLANK = 0;
	final static int WHITE = 1;
	final static int BLACK = 2;
	
	public static void main(String[] args) 
	{
		
		int data[] = {3, 35, 43, 64, 3, 34, 37, 56};
		
		
		int [][] board = new int[8][8];
		int[] black = new int[10];
		int[] white = new int[10];
		int count = 1;
		
		for (int r = 0; r < 8; r++)
		{
			for (int c = 0; c < 8; c++)
			{
				board[r][c] = BLANK;
			}
		}
		
		
		for (int x = 0; x < data[0]; x++)
		{
			int count1 = 0;
			
			board[toRow(data[count])][ (toCol(data[count])) ] = WHITE;
			black[count1] = data[count];
			count1++;
			count++;
		}
		int blackNum = data[count];
		count++;
		for (int x = 0; x < blackNum; x++)
		{
			int count1 = 0;
			board[(data[count] - 1) / 8][(data[count] - 1) % 8] = BLACK;
			white[count1] = data[count];
			count1++;
			count++;
		}
		
		
		for (int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				//System.out.print(board[x][y] + " ");
			}
			//System.out.println();
		}
		
		for (int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				if (board[x][y] == WHITE)
				{
					if (board[x + 1][y] == BLACK || board[x - 1][y] == BLACK ||board[x][y + 1] == BLACK ||board[x][y - 1] == BLACK)
						System.out.println(toNum(x, y));
				}
			}
		}
		


	}
	
	
	public static int[] captured(int[][] board, int start)
	{
		boolean found = false;
		int[] captured = new int[10];
		int count = 0;
		for (int x = 1; x <= toCol(start); x++) // captures going up
		{
			if (board[toRow(start)][toCol(start) - x] == WHITE)
			{
				found = true;
				
			}
			else if (found == false)
			{
				x = toCol(start);
				break;
			}
			else if (found == true)
			{
				if (board[toRow(start)][toCol(start) - x] == BLACK || x == toCol(start))
				{
					for (int y = 0; y < x; y++)
					{
						System.out.println(toRow(start) + " " + toCol(start));
						captured[count] = toNum(toRow(start), toCol(start - x));
						count++;
					}
				}
			}
		}
		
		found = false;
		count = 0;
		for (int x = 1; x <= 7 - toCol(start); x++) // captures going down
		{
			if (board[toRow(start)][toCol(start) + x] == WHITE)
			{
				found = true;
			}
			else if (found == false)
			{
				x = 7 - toCol(start);
				break;
			}
			else if (found == true)
			{
				if (board[toRow(start)][toCol(start) - x] == BLACK || x == 7 - toCol(start))
				{
					for (int y = 0; y < x; y++)
					{
						System.out.println(toRow(start) + " " + toCol(start));
						captured[count] = toNum(toRow(start), toCol(start + x));
						count++;
					}
				}
			}
		}
		
		found = false;
		count = 0;
		
		for (int x = 1; x <= (7 - toRow(start)); x++) // captures going right
		{
			//System.out.println("..");
			//System.out.println(x);
			if (board[toRow(start) + x][toCol(start)] == WHITE)
			{
				found = true;
			}
			else if (found == false)
			{
				
				x = 7 - toRow(start);
				break;
			}
			else if (found == true)
			{
				if (board[toRow(start) + x][toCol(start)] == BLACK || x == 7 - toRow(start))
				{
					for (int y = 0; y < x; y++)
					{
						System.out.println(toRow(start) + " " + toCol(start));
						captured[count] = toNum(toRow(start) + y, toCol(start));
						count++;
					}
				}
			}
		}
		
		found = false;
		count = 0;
		
		for (int x = 1; x <= toRow(start); x++) // captures going left
		{
			if (board[toRow(start) - x][toCol(start)] == WHITE)
			{
				found = true;
			}
			else if (found == false)
			{
				x = toRow(start);
				break;
			}
			else if (found == true)
			{
				if (board[toRow(start) + x][toCol(start)] == BLACK || x == toRow(start))
				{
					for (int y = 0; y < x; y++)
					{
						System.out.println(toRow(start) + " " + toCol(start));
						captured[count] = toNum(toRow(start) - y, toCol(start));
						count++;
					}
				}
			}
		}
		return captured;
	}
	
	public static int toCol(int x)
	{
		return (x-1)%8;
	}
	public static int toRow (int x)
	{
		return (x-1)/8;
	}
	public static int toNum (int row, int col)
	{
		return (row * 8) + (col + 1);
	}
	public static int[] possible_moves (int start)
	{
		int[] pos_moves = new int[8];
		int count = 0;
		if (toRow(start) > 2) //up 3
		{
			if (toCol(start) < 6)
			{
				pos_moves[count] = toNum(toRow(start) - 3, toCol(start) + 2); // right 2
				count++;
			}
			if (toCol(start) > 1)
			{
				pos_moves[count] = toNum(toRow(start) - 3, toCol(start) - 2); // left 2
				count++;
			}	
		}
		if (toRow(start) < 5) // down 3
		{
			if (toCol(start) < 6)
			{
				pos_moves[count] = toNum(toRow(start) + 3, toCol(start) + 2);
				count++;
			}
			if (toCol(start) > 1)
			{
				pos_moves[count] = toNum(toRow(start) + 3, toCol(start) - 2);
				count++;
			}		
		}
		if (toRow(start) > 1) // up 2
		{
			if (toCol(start) < 5)
			{
				pos_moves[count] = toNum(toRow(start) - 2, toCol(start) + 3); // right 3
				count++;
			}
			if (toCol(start) > 2)
			{
				pos_moves[count] = toNum(toRow(start) - 2, toCol(start) - 3); // down 3
				count++;
			}
				
		}
		
		if (toRow(start) < 6) // down 2
		{
			if (toCol(start) < 5)
			{
				pos_moves[count] = toNum(toRow(start) + 2, toCol(start) + 3); // right 3
				count++;
			}
			if (toCol(start) > 2)
			{
				pos_moves[count] = toNum(toRow(start) + 2, toCol(start) - 3); // down 3
				count++;
			}
		}
		
		return pos_moves;
	}

}
