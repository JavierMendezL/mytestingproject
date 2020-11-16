package SesionProblemasDos;

public class Move {
	
	private int row, col;
	private boolean noMove = false;
	private boolean gameOver = false;

	public Move() {}
	public int getRow() {return row;}
	public int getCol() {return col;}
	
	public Move(int r, int c) {
		row = r;
		col = c;
	}
	
	public Move(Move t) {

		row = t.getRow();
		col = t.getCol();
	}
	
	public void surrender(){
		gameOver = true;
		noMove = true;
	}
	
	public void invalidM(){
		noMove = true;
	}
	
	public boolean gameOver(){
		return gameOver;
	}

	boolean noAvaliableMoves() {
		return noMove;
	}
}