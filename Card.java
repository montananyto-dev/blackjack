class Card {
	private String suite;
	private int value;
	
	public Card(String t_suite, int t_value) {
		this.suite = t_suite;
		this.value = t_value;
	}
	
	private String getSuite() {
		return suite;
	}
	
	public int getValue() {
		return value;
	}
	
	private String getType() {
		switch(getValue()) {
			case 1 : return "Ace";
			case 11 : return "Jack";
			case 12 : return "Queen";
			case 13 : return "King";
			default : return Integer.toString(value);
		}
	}
	
	public String toString() {
		return getType() + " of " + getSuite() + "s";
	}
}