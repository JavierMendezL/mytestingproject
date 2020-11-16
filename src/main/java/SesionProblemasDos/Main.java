package SesionProblemasDos;

public class Main {
	
	/*Class oriented to start a game with two human players*/
	public static void main(String args[]) {	
		Player p1 = new Player();
		Player p2 = new Player();
		Otello partida = new Otello();
		partida.GameStart(p1, p2);
	}
}
