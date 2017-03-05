class Card {
	private String m_suite;
	private int m_value;

	public Card(String t_suite, int t_value) {
		m_suite = t_suite;
		m_value = t_value;
	}

	private String getSuite() {
		return m_suite;
	}

	public int getValue() {
		return m_value;
	}

	private String getType() {
		switch(getValue()) {
			case 1 : return "Ace";
			case 11 : return "Jack";
			case 12 : return "Queen";
			case 13 : return "King";
			default : return Integer.toString(getValue());
		}
	}

	public String toString() {
		return getType() + " of " + getSuite() + "s";
	}
}
