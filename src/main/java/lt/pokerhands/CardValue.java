package lt.pokerhands;

public enum CardValue {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    final String code;

    private CardValue(String code) {
        this.code = code;
    }

    public static CardValue of(char code) {
        for (CardValue value : values()) {
            if (value.code.equals(String.valueOf(code))) {
                return value;
            }
        }
        throw new RuntimeException("Invalid value of card: " + code);
    }

}
