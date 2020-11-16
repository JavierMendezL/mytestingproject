package SesionProblemasDos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OtelloTestWhite {
	@Test public void WhiteBox_checkChange_decision() {
		/*Posible correct move with 1 swap*/
		Otello n = new Otello();
		boolean aux = n.checkChange('w', 6, 4, 0);
		assertTrue(aux);
		
		/*Incorrect moves*/
		/*Player not able to move in the selected square*/
		aux = n.checkChange('b', 3, 5, 1);
		assertFalse(aux);
		
		/*Player already in the square/Opponent player already in the square*/
		aux = n.checkChange('b', 4, 5, 1);
		assertFalse(aux);
	}
	
	@Test public void WhiteBox_validMove_conditional() {
		/*Condition coverage*/
		/*if((A && B) && (C && D)) {
			if(E) {
				for()
					if(F) {
						return true;}}}
		 return false;
		 }*/
		/*In order to do a proper condition coverage, a, b, c, d, e, f need to be both, true or false in a point of the test*/
		/*A true, B false, C false, D true*/
		Otello n = new Otello();			
		boolean t = n.validMove('b', -4, 9);
		assertFalse(t);
		/*A false, B true, C true, D false*/
		t = n.validMove('b', 14, -4);
		assertFalse(t);
		/*A true, B false, C true, D false*/
		t = n.validMove('b', -4, -4);
		assertFalse(t);
		/*A false, B true, C true, D true*/
		t = n.validMove('b', 14, 4);
		assertFalse(t);
		/*A true, B true, C false, D true*/
		t = n.validMove('b', 6, 40);
		assertFalse(t);
		/*A true, B false, C true, D true*/
		t = n.validMove('b', -7, 4);
		assertFalse(t);
		/*A false, B true, C false, D true*/
		t = n.validMove('b', 40,75);
		assertFalse(t);
		/*A true, B true, C true, D false*/
		t = n.validMove('b', 4,-5);
		assertFalse(t);
		/*ABCD true, so the program reaches E*/
		/*E false*/
		t = n.validMove('b', 4, 4);
		assertFalse(t);
		/*E true, so the program reaches F*/
		/*F false*/
		t = n.validMove('b', 2, 2);
		assertFalse(t);
		/*F true*/
		t = n.validMove('b', 3, 4);
		assertTrue(t);
	}
}
