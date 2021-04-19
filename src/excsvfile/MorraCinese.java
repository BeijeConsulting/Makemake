package excsvfile;

public class MorraCinese {
	public static void main(String[] args) {
		
		String player1 = args[0];
		String player2 = args[1];
		
		String[] match = {"carta", "sasso", "forbice"};

		if (player1.equals(match[0]) && player2.equals(match[1]) || player1.equals(match[1]) && player2.equals(match[2]) 
				|| player1.equals(match[2]) && player2.equals(match[0]))
			System.out.println("The winner is player one!");
		else if(player2.equals(match[0]) && player1.equals(match[1]) || player2.equals(match[1]) && player1.equals(match[2]) 
				|| player2.equals(match[2]) && player1.equals(match[0]))
			System.out.println("The winner is player two!");
		else System.out.println("It's a tie!!!");
	}

}
