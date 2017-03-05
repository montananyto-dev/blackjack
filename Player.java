import java.util.ArrayList;

class Player {
	public static int m_activePlayers = 0;
	private String m_name;
	private int m_age;
	private ArrayList<Card> m_hand;
	private boolean m_active;



	public Player(String name,int age){
		m_activePlayers+=1;
		m_active=true;
		m_name = name;
		m_age = age;
		m_hand = new ArrayList<Card>() ;
		m_hand.addAll(Deck.drawPair());
	}

	public void setName(String name){
		m_name = name;
	}

	public String getName (){
		return m_name;
	}

	public void setAge (int age){
		m_age = age;
	}

	public int getAge(){
		return m_age;
	}

	public void setHand(ArrayList<Card> hand){
		m_hand = hand;
	}

	public void addCard(Card aCard) {
		m_hand.add(aCard);
	}

	public ArrayList<Card> getHand(){
		return m_hand;
	}

	public int getTotalValue() {
		int value=0;
		int aceCount=0;
		for(Card card : m_hand) {
			if(card.getValue()==1) { //is an Ace
				aceCount+=1;
			} else { //not Ace
				value+=card.getValue();
			}
		}

		for(int i=0; i<aceCount; i++) {
			if(value+11 > 21) {
				value+=1;
			} else {
				value+=11;
			}
		}

		return value;
	}

	public boolean goneOver() {
		return getTotalValue()>21;
	}

	public void printHand() {
		for(Card aCard : m_hand)
			System.out.print(aCard + "\n");
	}

	public boolean isActive() {
		return m_active;
	}

}
