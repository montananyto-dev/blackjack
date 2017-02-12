import java.util.ArrayList;

class Player{

private String name;
private int age;
private ArrayList<Card> hand;


public Player( String name,int age){
	
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

public ArrayList<Card> getHand(){
	
	return hand;
}

public boolean goneOver() {
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
	System.out.println("Value: " + value);
	return value>21;
}

public void printHand() {
	for(Card aCard : hand)
		System.out.println(aCard);
}

}