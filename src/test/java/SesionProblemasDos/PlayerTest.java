package SesionProblemasDos;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;


public class PlayerTest {
	
	@Test public void Blackbox_MakeMove() {
		Otello testgame = new Otello();
        Player classUnderTest = new Player();
        
        /*Correct input #1*/
        ByteArrayInputStream in = new ByteArrayInputStream("3 4".getBytes());
        System.setIn(in);
        Move testmove = classUnderTest.makeMove(testgame);
        
        assertEquals(testmove.getRow(), 3);
        assertEquals(testmove.getCol(), 4);
        assertEquals(testmove.noAvaliableMoves(), false);
        assertEquals(testmove.gameOver(), false);
        
        /*Correct input #2*/
        in = new ByteArrayInputStream("4 3".getBytes());
        System.setIn(in);
        testmove = classUnderTest.makeMove(testgame);
        
        assertEquals(testmove.getRow(), 4);
        assertEquals(testmove.getCol(), 3);
        assertEquals(testmove.noAvaliableMoves(), false);
        assertEquals(testmove.gameOver(), false);
        
        /*Correct input #3*/
        in = new ByteArrayInputStream("6 5".getBytes());
        System.setIn(in);
        testmove = classUnderTest.makeMove(testgame);
        
        assertEquals(testmove.getRow(), 6);
        assertEquals(testmove.getCol(), 5);
        assertEquals(testmove.noAvaliableMoves(), false);
        assertEquals(testmove.gameOver(), false);
        
        /*Correct input #4*/
        in = new ByteArrayInputStream("5 6".getBytes());
        System.setIn(in);
        testmove = classUnderTest.makeMove(testgame);
        
        assertEquals(testmove.getRow(), 5);
        assertEquals(testmove.getCol(), 6);
        assertEquals(testmove.noAvaliableMoves(), false);
        assertEquals(testmove.gameOver(), false);
        
	}
	
	@Test public void Blackbox_MakeMove_SurrenderCase() {
		Otello testgame = new Otello();
        Player classUnderTest = new Player();
		
        ByteArrayInputStream in = new ByteArrayInputStream("-1 7".getBytes());
        System.setIn(in);
        Move testmove = classUnderTest.makeMove(testgame);
        
        assertEquals(testmove.getRow(), 0);
        assertEquals(testmove.getCol(), 0);
        assertEquals(testmove.noAvaliableMoves(), true);
        assertEquals(testmove.gameOver(), true);
	}
	
	@Test public void BlackBox_MakeMove_UnableToMove() {
		Otello testgame = new Otello();
		testgame.setTestB();
        Player classUnderTest = new Player();
        
        Move testmove = classUnderTest.makeMove(testgame);
   
        assertEquals(testmove.getRow(), 0);
        assertEquals(testmove.getCol(), 0);
        assertEquals(testmove.noAvaliableMoves(), true);
        assertEquals(testmove.gameOver(), false);

	}
	
}