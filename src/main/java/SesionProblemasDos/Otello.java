package SesionProblemasDos;

import java.lang.String;

public class Otello {
	private static final int size = 8;
	private char board[][];
	public static String liner = System.getProperty("line.separator");
	
	public Otello() {
		board = new char[size+2][size+2];
		int i,j;
		for(i=1; i<size+1; i++)
			for(j=1; j<size+1; j++)
				board[i][j] = '.';
		for(i=0; i<size+2; i++) 
			board[0][i] = board[i][0] = board[size+1][i] = board[i][size+1] = '*';
		i = size/2;
		board[i][i] = board[i+1][i+1] = 'w';
		board[i][i+1] = board[i+1][i] = 'b';
	}
	
	public char[][] getBoard() {return board;}
	
	
	public char CheckOpponentColor(char player) {
		if (player == 'b')
			return 'w';
		else
			return 'b';
	}
	
	/*This method checks if a player has moves avaliable in his turn*/
	public boolean posibleMoves(char player) {
		for(int i=1; i<=size; i++)
			for(int j=1; j<=size; j++)
				if(validMove(player,i,j))
					return true;
		return false;
	}
	
	/*This method takes a player and a posible move (row & column) 
	 * and checks if there is a posible move in the desired position*/ 
	public boolean validMove(char player,int r, int c) {
		if((size >= r && r > 0) && (size >= c && c > 0)) {
			if(board[r][c] == '.') {
				for(int k=0; k<8; k++)
					if(checkChange(player,r,c,k)) {
						return true;
					}
			}
		}
		return false;
	}
	
	public void execMove(char player, Move t) {
		int row = t.getRow();
		int col = t.getCol();
		if(validMove(player,row,col)) {
			board[row][col] = player;
			for(int i=0; i<size; i++) {
				colorChange(player,row,col,i);
			}			
		}
	}
	
	public int countColors(char c) {
		if (Character.isUpperCase(c)) {
			c = Character.toLowerCase(c);
		}
		int aux = 0;
		for (int col = 1 ; col <= size; col++) {
			for (int row = 1; row <= size; row++) {
				if (board[col][row] == c) {
					aux++;
				}
			}
		}
		return aux;
	}

	/*This class gets a row a column and a direction, and using the direction given measures if a change is done
	 * returning a true if there is a change and a false in case it isn't, allowing us to know if this is a posible
	 * move for the player.
	 */
	public boolean checkChange(char player, int row, int col, int dir) {
		int dir1[] = {-1,1,0,0,1,-1,1,-1};
		int dir2[] = {0,0,1,-1,1,-1,-1,1};
		boolean flag = false;
		for(int i=0; i<8; i++){
			row+=dir1[dir];
			col+=dir2[dir];
			if(board[row][col] == CheckOpponentColor(player)){
				flag = true;
			}
			else if(board[row][col] == player){
					if(flag)
						return true;
					else return false;
			}
			else return false;
		}
		return false;
	}
	
	public void colorChange(char player, int row, int col, int dir) {
		int dir1[] = {-1,1,0,0,1,-1,1,-1};
		int dir2[] = {0,0,1,-1,1,-1,-1,1};
		if(checkChange(player,row,col,dir)) {
			col+=dir2[dir];
			row+=dir1[dir];
			while(board[row][col] != player) {
				board[row][col] = player;
				row+=dir1[dir];
				col+=dir2[dir];				
			}
		}
	}
	
	public String PrintBoard() {
		String res = new String();
		res = "  ";
		for (int i = 1; i <= size; i++) {
			res += Integer.toString(i) + " ";
		}
		res += liner;
		for (int y = 1; y <= size; y++) {
			res += Integer.toString(y) + " ";
			for (int x = 1; x <= size; x++) {
				res += Character.toString(board[y][x]) + " ";
			}
			res += liner;
		}
		return res;
	}
	
	
	/*Core method of the program, we initialize both players, giving them both colors and an identifier
	 * and enter a while loop that ends whenever the game ends, in it we firstly check both players colors,
	 * make a move, and later check, if for the player there is no moves avaliable, if the game is won or 
	 * lost, or if we can proceed it as a normal turn.
	 */
	public void GameStart(Player p1, Player p2) {
		p1.initialize("p1", 'b');
		p2.initialize("p2", 'w');
		char currentMove = 'b';
		
		while (true) {
			Move move;
			
			/*Black turn if*/
			if (currentMove != 'b' ) {
				System.out.println(PrintBoard());
				move = p2.makeMove(this);
				if (move.noAvaliableMoves()) {
					if(posibleMoves(p1.colour)) {
						System.out.println(p2.name + " moves.");
						if(move.gameOver()) {
							System.out.println(p2.name + " wins. Game Over!\n");
							break;
						}
						else {
							System.out.println("There is no possible moves for " + p2.name);
							System.out.println(liner);
							currentMove = 'b';
						}
					}
					else {
						System.out.println("Game over!\n");
						int difference = countColors(p1.colour) - countColors(p2.colour);
						if(difference<0)
							System.out.println(p2.name + " wins.");
						else System.out.println(p1.name + " wins.");
						break;
					}
				}
				else {
					System.out.println(p2.name + " moves.");
					execMove(p2.colour, move);
					currentMove = 'b';
					System.out.println(liner);
					String moveString = "Move done: " + Integer.toString(move.getRow()) + ", " + Integer.toString(move.getCol());
					System.out.println(moveString);
					System.out.println(liner);
					continue;
				}
			}
			
			/*White turn if*/
			if (currentMove != 'w') {
				System.out.println(PrintBoard());	
				move = p1.makeMove(this);
				if (move.noAvaliableMoves()) {
					if(posibleMoves(p2.colour)) {
						System.out.println(p1.name + " moves.");
						if(move.gameOver()) {
							System.out.println(p2.name + " wins. Game Over!\n");
							break;
						}
						else {
							System.out.println("There is no possible moves for " + p1.name);
							System.out.println(liner);
							currentMove = 'w';
						}
					}
					else {
						System.out.println("Game over!\n");
						int difference = countColors(p1.colour) - countColors(p2.colour);
						if(difference<0)
							System.out.println(p2.name + " wins.");
						else System.out.println(p1.name + " wins.");
						break;
					}
				}
				else {
					System.out.println(p1.name + " moves.");
					execMove(p1.colour, move);
					System.out.println(liner);
					String moveString = "Move done: " + Integer.toString(move.getRow()) + ", " + Integer.toString(move.getCol());
					System.out.println(moveString);
					System.out.println(liner);
					currentMove = 'w';
					continue;
				}
			}
		}
	}
	
	/*Test Method*/
	public void setTestB() {
		board[4][5] = 'w';
		board[5][4] = 'w';
	}
	/*Test Method*/
}