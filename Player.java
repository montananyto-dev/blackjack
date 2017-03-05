import java.util.ArrayList;

class Player {

	private String m_name;
	private int m_age;
	private ArrayList<Card> m_hand;
	private boolean m_active;
	private PlayerState m_state;



	public Player(String name,int age){
		m_state = PlayerState.ACTIVE;
		m_name = name;
		m_age = age;
		m_hand = new ArrayList<Card>() ;
		m_hand.addAll(Deck.drawPair());
	}

	public PlayerState getState() {
		return m_state;
	}

	public void setState(PlayerState state) {
		m_state = state;
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
		System.out.println("(" + getTotalValue() + ")");
	}

}
