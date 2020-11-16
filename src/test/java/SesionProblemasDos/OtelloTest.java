package SesionProblemasDos;

import org.junit.Test;
import static org.junit.Assert.*;

public class OtelloTest {
	
	@Test public void Blackbox_CheckOpponentColor() {
		Otello n = new Otello();
		
		/*Black color ask*/
		char t = n.CheckOpponentColor('b');
		assertEquals(t, 'w');
		
		/*White color ask*/
		t = n.CheckOpponentColor('w');
		assertEquals(t, 'b');
	}
	
	@Test public void Blackbox_posibleMoves() {
		/*Posible moves*/
		Otello n = new Otello();
		boolean t = n.posibleMoves('w');
		assertTrue(t);
		t = n.posibleMoves('b');
		assertTrue(t);
		
		/*No posible moves*/
		n.setTestB();
		t = n.posibleMoves('w');
		assertFalse(t);
		t = n.posibleMoves('b');
		assertFalse(t);
	}
	
	@Test public void Blackbox_ValidMove() {
		Otello n = new Otello();
		/*White player tests*/
		/*Good move*/
		boolean t = n.validMove('w', 3, 5);
		assertTrue(t);
		/*Bad move*/
		t = n.validMove('w', 3, 4);
		assertFalse(t);
		
		/*Black player tests*/
		/*Good move*/
		t = n.validMove('b', 3, 4);
		assertTrue(t);
		/*Bad move*/
		t = n.validMove('b', 3, 5);
		assertFalse(t);
			
	}
	

	
	
	@Test public void Blackbox_execMove() {
		Otello n = new Otello();
		Move m = new Move(3, 4);
		/*Correct black move*/
		n.execMove('b', m);
		char aux[][] = n.getBoard();
		assertEquals('b', aux[3][4]);
		assertEquals('b', aux[4][4]);
		
		/*Correct white move*/
		m = new Move(3, 5);
		n.execMove('w', m);
		aux = n.getBoard();
		assertEquals('w', aux[3][5]);
		assertEquals('w', aux[4][5]);
		
		/*Incorrect white move*/
		m = new Move(7, 5);
		n.execMove('w', m);
		aux = n.getBoard();
		assertEquals('.', aux[7][5]);

		/*Incorrect black move*/
		m = new Move(2, 7);
		n.execMove('b', m);
		aux = n.getBoard();
		assertEquals('.', aux[2][7]);
	}
	
	@Test public void Blackbox_countColors() {
		/*Test #1*/
		Otello n = new Otello();
		int aux = n.countColors('b');
		assertEquals(2, aux);
		aux = n.countColors('w');
		assertEquals(2, aux);
		
		/*Test #2*/
		Move m = new Move(3, 4);
		n.execMove('b', m);
		m = new Move(3, 5);
		n.execMove('w', m);
		m = new Move(3, 6);
		n.execMove('b', m);
		m = new Move(2, 5);
		n.execMove('w', m);
		m = new Move(5, 6);
		n.execMove('b', m);
		
		aux = n.countColors('b');
		assertEquals(7, aux);
		aux = n.countColors('w');
		assertEquals(2, aux);
		
	}
	
	@Test public void Blackbox_checkChange() {
		/*Posible correct move with 1 swap*/
		/*#1*/
		Otello n = new Otello();
		boolean aux = n.checkChange('w', 6, 4, 0);
		assertTrue(aux);
		
		/*#2*/
		aux = n.checkChange('b', 3, 4, 1);
		assertTrue(aux);
		
		/*#3*/
		aux = n.checkChange('b', 4, 3, 2);
		assertTrue(aux);
		
		/*#4*/
		aux = n.checkChange('w', 4, 6, 3);
		assertTrue(aux);
		
		/*Incorrect moves*/
		/*Player not able to move in the selected square*/
		aux = n.checkChange('b', 3, 5, 1);
		assertFalse(aux);
		
		/*Player already in the square/Opponent player already in the square*/
		aux = n.checkChange('b', 4, 5, 1);
		assertFalse(aux);
		aux = n.checkChange('b', 4, 4, 1);
		assertFalse(aux);
		
		/*Player too far away from the target to change color*/
		aux = n.checkChange('b', 4, 2, 2);
		assertFalse(aux);
}
	
	@Test public void Blackbox_colorChange() {
		Otello n = new Otello();
		
		/*Incorrect moves*/
		/*Player not able to move in the selected square*/
		n.colorChange('b', 3, 5, 1);
		char aux[][] = n.getBoard();
		assertEquals(aux[3][5], '.');
		
		/*Player already in the square/Opponent player already in the square*/
		n.colorChange('b', 4, 5, 1);
		aux = n.getBoard();
		assertEquals(aux[4][5], 'b');
		n.colorChange('b', 4, 4, 1);
		aux = n.getBoard();
		assertEquals(aux[4][4], 'w');
		
		/*Player too far away from the target to change color*/
		n.colorChange('b', 4, 2, 2);
		aux = n.getBoard();
		assertEquals(aux[4][2], '.');
		
		/*Correct moves*/
		/*#1*/
		n.colorChange('b', 3, 4, 1);
		aux = n.getBoard();
		assertEquals(aux[3][4], '.');
		assertEquals(aux[4][4], 'b');
		
		/*#2*/
		n.colorChange('w', 3, 3, 4);
		aux = n.getBoard();
		assertEquals(aux[3][3], '.');
		assertEquals(aux[4][4], 'w');
		
		/*#3*/
		n.colorChange('b', 4, 3, 2);
		aux = n.getBoard();
		assertEquals(aux[4][3], '.');
		assertEquals(aux[4][4], 'b');
	}
}