import java.util.ArrayList;

class Player {
	public static int activePlayers = 0;
	private String name;
	private int age;
	private ArrayList<Card> hand;
	private boolean active;



	public Player( String name,int age){
		this.activePlayers+=1;
		this.active=true;
		this.name = name;
		this.age = age;
		this.hand = new ArrayList<Card>() ;
		hand.addAll(Deck.drawPair());
	}

	public void setName( String name ){
		this.name = name;
	}

	public String getName (){
		return name;
	}

	public void setAge (int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setHand(ArrayList<Card> hand){
		this.hand = hand;
	}

	public void addCard(Card aCard) {
		hand.add(aCard);
	}

	public ArrayList<Card> getHand(){
		return hand;
	}

	public int getTotalValue() {
		int value=0;
		int aceCount=0;
		for(Card card : hand) {
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
		for(Card aCard : hand)
			System.out.print(aCard + "\n");
	}

	public boolean isActive() {
		return this.active;
	}

}
