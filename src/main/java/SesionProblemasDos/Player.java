package SesionProblemasDos;

import java.lang.String;
import java.util.Scanner;

public class Player {
	public char colour ='.';
	public String name = "p";

	public Player() {
	}

	public void initialize(String pName, char pColour) {
		name = pName;
		colour = pColour;
	}

	
	public Move makeMove(Otello game)
	{
		boolean verifyInput = false;
		Move move = null;
		Scanner scanner = new Scanner(System.in);
		int col, row;
		/*No hay movimientos disponibles*/
		if(game.posibleMoves(colour) == false) {
			Move im = new Move(0,0);
			im.invalidM();
			System.out.println("There is no posible moves.\n");
			return im;
		}
		while (!verifyInput) {
			System.out.println("Input next move (row col) or -1 to surrender: ");		
			try{
				row = scanner.nextInt();
				/*Surrender*/
				if (row == -1) {
					Move sr = new Move(0, 0);
					sr.surrender();
					return sr;
				}
				/*Movimiento normal*/
				else {
					col = scanner.nextInt();
					if (game.validMove(colour,row,col))	{
						move = new Move(row,col);
						verifyInput = true;
					}
					else
						System.out.println("Impossible move or input.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input.");
			}
		};			
		return move;
	}
}
