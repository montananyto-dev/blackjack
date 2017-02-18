import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class Board{

	private static ArrayList<Player> players;
	private Scanner scan;
	private String answer;


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
			System.out.println("Your hand is ");player.printHand();
			System.out.println("\n");

			do {
				System.out.println("Would you like a card");
				answer = scan.nextLine();

			}while (giveNewCardIfYes(answer,player));

		}
	}

		private boolean giveNewCardIfYes(String answer,Player player){

			if (answer.equals("Yes")){
				player.addCard(Deck.drawCard());
				player.printHand();
				return false;
			}else{
				return true;
			}

			}

	private int reqPlayerNumber() {
		System.out.println("How many Players");
		String input = scan.nextLine();

		return Integer.parseInt(input);
	}

	private String reqPlayerName() {
		boolean nameInUse = true;
		String input;
		do {
			System.out.println("Name of the player");
			input = scan.nextLine();
			nameInUse=playerExists(input);
			if(nameInUse) { System.out.println("Name is already used."); }
		} while(nameInUse);

		return input;
	}

	private int reqPlayerAge() {
		System.out.println("Age of the player");
		String input = scan.nextLine();

		return Integer.parseInt(input);

	}

	private boolean playerExists(String newName) {
		for(Player aPlayer : players)
			if(aPlayer.getName().equals(newName))
				return true;

		return false;
	}

}
