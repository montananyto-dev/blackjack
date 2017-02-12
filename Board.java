import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class Board{

	private static ArrayList<Player> players;
	private Scanner scan;


	public Board() {
		Deck.init();
		
		scan = new Scanner(System.in);
		
		players = new ArrayList<Player>();
		
		int numberOfPlayers = reqPlayerNumber();

		do{
			String name = reqPlayerName();

			int age = reqPlayerAge();

			
			Player player = new Player(name,age);
			players.add(player);
			
			System.out.println("Hand of player " + player.getName());
			
			player.printHand();
			System.out.println("\n");

			numberOfPlayers --;


			}while ( numberOfPlayers > 0 );
		
			
			Iterator<Player> iterator = players.iterator();
		
			while (iterator.hasNext()) {
				
			Player player = iterator.next();
           
			System.out.println("It is your turn " + player.getName()+ "\n");
			System.out.println("Your hand is " + player.getHand());
			System.out.println("Would you like an other card");
			String answer = scan.nextLine();
			
			if ( answer == "Yes" ){
				
				player.addCard(Deck.drawCard());
				System.out.println(player.getHand());
				
				
			}
		   
        }

	}
	
	private int reqPlayerNumber() {
		System.out.println("How many Players");
		String input = scan.nextLine();
		
		return Integer.parseInt(input);
	}
	
	private String reqPlayerName() {
		System.out.println("Name of the player");
		String input = scan.nextLine();
		
		return input;
	}
	
	private int reqPlayerAge() {
		System.out.println("Age of the player");
		String input = scan.nextLine();
		
		return Integer.parseInt(input);
		
	}

}
