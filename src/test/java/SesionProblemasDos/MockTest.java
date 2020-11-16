package SesionProblemasDos;

import org.junit.Test;


/*This test is implemented thanks to the mock class created for player, this simulates a game inputing all the moves, allowing to test in a more efficient way the core function of the game*/
public class MockTest {
	public int l1[][]= {{4, 3},{6, 4},{3, 4},{5, 6},{4, 6},{7, 6},{4, 2}
	,{2, 3},{3, 1},{3, 6},{7, 4},{3, 2},{5, 2},{2, 5},{2, 6}
	,{5, 8},{1, 4},{2, 8},{6, 1},{1, 3},{6, 3},{5, 7},{3, 7}
	,{7, 7},{4, 8},{8, 7},{8, 5},{1, 7},{1, 1},{8, 2},{8, 1}};
	public int l2[][] = {{5, 3},{3, 3},{3, 5},{6, 6},{6, 5},{4, 7}
	,{8, 6},{4, 1},{2, 1},{7, 5},{7, 3},{2, 4},{5, 1},{1, 6}
	,{2, 2},{2, 7},{3, 8},{1, 8},{7, 1},{1, 5},{1, 2},{7, 2}
	,{6, 7},{8, 8},{6, 8},{7, 8},{8, 4},{6, 2},{8, 1},{8, 3}};

	@Test public void Test_MockObject() {
		Player p1 = new Mock(l1, 'b', "p1");
		Player p2 = new Mock(l2, 'w', "p2");
		
		Otello partida = new Otello();
		partida.GameStart(p1, p2);
	}
	
	/*Full game array: {{4, 3},{5, 3},{6, 4},{3, 3},{3, 4},{3, 5},{5, 6},{6, 6},{4, 6},{6, 5},{7, 6},{4, 7},{4, 2}
	,{8, 6},{2, 3},{4, 1},{3, 1},{2, 1},{3, 6},{7, 5},{7, 4},{7, 3},{3, 2},{2, 4},{5, 2},{5, 1},{2, 5},{1, 6},{2, 6}
	,{2, 2},{5, 8},{2, 7},{1, 4},{3, 8},{2, 8},{1, 8},{6, 1},{7, 1},{1, 3},{1, 5},{6, 3},{1, 2},{5, 7},{7, 2},{3, 7}
	,{6, 7},{7, 7},{8, 8},{4, 8},{6, 8},{8, 7},{7, 8},{8, 5},{8, 4},{1, 7},{6, 2},{1, 1},{8, 1},{8, 2},{8, 3},{8, 1}};*/
}
