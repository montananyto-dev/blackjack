class Card {
	private String m_suite;
	private String m_type;

	public Card(String suite, String type) {
		m_suite = suite;
		m_type = type;
	}

	private String getSuite() {
		return m_suite;
	}

	public int getValue() {
		switch(getType()) {
			case "Ace" : return 1;
			case "Jack" :
			case "Queen" :
			case "King" : return 10;
			default : return Integer.parseInt(getType());
		}
	}

	private String getType() {
		return m_type;
	}

	public String toString() {
		return getType() + " of " + getSuite() + "s";
	}
}
