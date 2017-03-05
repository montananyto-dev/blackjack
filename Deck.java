import java.util.ArrayList;
import java.util.Random;

class Deck {
	//remove static when main becomes constructor!
	private static ArrayList<Card> m_cards;

	//will be constructor
	//public static void main(String[] args) {

	public static void init() {
		m_cards = new ArrayList<>();

		String[] suites = {"Diamond","Club","Heart","Spade"};
		String[] types =  {"Ace","1","2","3","4","5","6","7","8","9","10","Jack","King","Queen"};

		for(String s : suites) {
			for(String t : types) {
				m_cards.add(new Card(s,t));
			}
		}
	}

	public static Card drawCard() {
		Random rnd = new Random();
		Card drawn = m_cards.get(rnd.nextInt(m_cards.size()));
		m_cards.remove(drawn);

		return drawn;
	}

	public static ArrayList<Card> drawPair() {
		ArrayList<Card> pair = new ArrayList<>();
		pair.add(drawCard());
		pair.add(drawCard());

		return pair;
	}

	public static void displayAllCards(){

		for(Card card : m_cards ){

			System.out.println(card.toString() + " (" + card.getValue() + ")");
		}
		System.out.println("\n");
	}
}
