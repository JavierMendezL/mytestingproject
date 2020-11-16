package SesionProblemasDos;

public class Mock extends Player{
	public char colour ='.';
	public String name = "p";
	public int MockL[][];
	public int count = 0;
	
	public Mock() {
		
	}
	
	public Mock(int l[][], char pcolour, String p) {
		colour = pcolour;
		name = p;
		MockL = l;
	}
	
	public Move makeMove(Otello game)
	{
		System.out.println("A move has been done");
		Move aux = new Move();
		if(count < MockL.length) {
			aux = new Move(MockL[count][0], MockL[count][1]);
			count += 1;}
		else {
			aux.surrender();
		}
		
		return aux;
	}

}
