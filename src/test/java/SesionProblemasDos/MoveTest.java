package SesionProblemasDos;

import org.junit.Test;
import static org.junit.Assert.*;

/*This class stores a move and updates his values to know 
 * wether the game is over or wether there are no posible moves to do*/

public class MoveTest {
	
	@Test public void Blackbox_gameOver() {
		Move n = new Move();
		assertFalse(n.gameOver());
	}
	
	@Test public void Blackbox_noAvaliableMoves() {
		Move n = new Move();
		assertFalse(n.noAvaliableMoves());
	}
	
	@Test public void Blackbox_surrender() {
		Move n = new Move();
		
		assertFalse(n.gameOver());
		assertFalse(n.noAvaliableMoves());
		n.surrender();
		assertTrue(n.gameOver());
		assertTrue(n.noAvaliableMoves());
	}
	
	@Test public void Blackbox_invalidM() {
		Move n = new Move();
		
		assertFalse(n.gameOver());
		assertFalse(n.noAvaliableMoves());
		n.invalidM();
		assertFalse(n.gameOver());
		assertTrue(n.noAvaliableMoves());
	}
}