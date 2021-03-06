import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {

	private static ArrayList<Player> players;
	private Scanner scan;
	private String answer;


	public Board() {
		Deck.init();

		Deck.displayAllCards();

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

			while(activePlayerExists()) {
				Iterator<Player> iterator = players.iterator();
				while (iterator.hasNext()){

					Player player = iterator.next();
					if(player.getState() == PlayerState.ACTIVE) {
						System.out.println("It is your turn " + player.getName());
						System.out.println("Your hand is...");
						player.printHand();

						System.out.println("Would you like a card (Y/n)");
						answer = scan.nextLine();
						giveNewCardIfYes(answer,player);
					}
				}
			}

			String winnerName = "";
			int biggest =0;

			for(Player player: players) {
				if(player.getState() == PlayerState.INACTIVE) {
					if(player.getTotalValue() > biggest) {
						biggest = player.getTotalValue();
						winnerName = player.getName();
					}
				}
			}
			System.out.println("The winner is: " + winnerName + " with a score of " + biggest);
	}

	private boolean activePlayerExists() {
		for(Player player : players)
			if(player.getState() == PlayerState.ACTIVE)
				return true;

		return false;
	}

	private boolean giveNewCardIfYes(String answer,Player player){

		if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")){
			player.addCard(Deck.drawCard());
			player.printHand();
			if(player.goneOver()) {
				player.setState(PlayerState.LOST);
				System.out.println("You've gone over. Loser.");
				return false;
			}
			return true;
		}else{
			player.setState(PlayerState.INACTIVE);
			return false;
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
