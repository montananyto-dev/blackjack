import java.util.ArrayList;
import java.util.Random;

class Deck {
	//remove static when main becomes constructor!
	private static ArrayList<Card> cards;
	
	//will be constructor
	//public static void main(String[] args) {
	
	private static void init() {
		cards = new ArrayList<>();
		
		String[] suites = {"Diamond","Club","Heart","Spade"};
		
		for(int idx=0;idx<suites.length;idx++) {
			for(int val=1; val<14;val++) {
				cards.add(new Card(suites[idx],val));
			}
		}
	}
	
	public static Card drawCard() {
		checkInit();
		Random rnd = new Random();
		Card drawn = cards.get(rnd.nextInt(cards.size()));
		cards.remove(drawn);
		
		return drawn;
	}
	
	public static ArrayList<Card> drawPair() {
		ArrayList<Card> pile = new ArrayList<>();
		pile.add(drawCard());
		pile.add(drawCard());
		
		return pile;
	}
	
	private static void checkInit() {
		if(cards==null)
			init();
	}
	
}