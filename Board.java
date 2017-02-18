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
		boolean isNumber = false;
		boolean aboveLimit = true;
		String input;
		int amount=0;
		do {
			System.out.println("How many Players (max. 5)");
			input = scan.nextLine();

			isNumber = isNumeric(input);
			if(isNumber) {
				amount = Integer.parseInt(input);
				aboveLimit = amount > 5;
				if(aboveLimit) { System.out.println("Above maximum."); }
			} else { System.out.println("Not a number."); }
			
		} while(!isNumber || aboveLimit);

		return amount;
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
		int age = 0;
		boolean tooYoung = true;
		boolean isNumber = false;
		String input;
		do {
			System.out.println("Age of the player");
			input = scan.nextLine();

			isNumber = isNumeric(input);
			if(isNumber)	{
				age = Integer.parseInt(input);
				tooYoung = age < 18;
				if(tooYoung) { System.out.println("Too young."); }
			} else { System.out.println("Not a number."); }

		} while(tooYoung || !isNumber);

		return age;
	}

	private boolean playerExists(String newName) {
		for(Player aPlayer : players)
			if(aPlayer.getName().equals(newName))
				return true;

		return false;
	}

	//TODO Improve this! Very bad.
	private boolean isNumeric(String input) {
		try {
	    Integer.parseInt(input);
		} catch (NumberFormatException e) {
		    return false;
		}
		return true;
	}

}
