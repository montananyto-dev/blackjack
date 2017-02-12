import java.util.Scanner;
import java.util.ArrayList;


public class Board{

	private static ArrayList<Player> players;



	public Board() {

		System.out.println("How many Players");

		Scanner scan = new Scanner(System.in);
		int numberOfPlayers = scan.nextInt();

		players = new ArrayList<Player>();

		do{
			
			scan.nextLine();
			System.out.println("Name of the player");
			String name = scan.nextLine();

			System.out.println("Age of the player");
			int age = scan.nextInt();

			
			Player player = new Player(name,age);
			players.add(player);
			
			System.out.println("Hand of player " +player.getName());
			
			player.printHand();
			

			numberOfPlayers --;


		}while ( numberOfPlayers > 0 );



	}

}
