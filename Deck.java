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

		for(int idx=0;idx<suites.length;idx++) {
			for(int val=1; val<14;val++) {
				m_cards.add(new Card(suites[idx],val));
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
}
