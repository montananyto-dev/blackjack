import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class Board{

	private static ArrayList<Player> players;



	public Board() {
		Deck.init();
		System.out.println("How many Players");

		Scanner scan = new Scanner(System.in);
		int numberOfPlayers = scan.nextInt();
		System.out.println("\n");
		players = new ArrayList<Player>();
		

		do{
			
			scan.nextLine();
			System.out.println("Name of the player");
			String name = scan.nextLine();
			System.out.println("\n");
			System.out.println("Age of the player");
			int age = scan.nextInt();
			System.out.println("\n");

			
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
           
			System.out.println("It is your turn " + player.getName());
			System.out.println("Your hand is " + player.getHand());
		   
        }

		}

	}


