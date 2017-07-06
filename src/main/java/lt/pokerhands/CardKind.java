package lt.pokerhands;

public enum CardKind {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    String code;

    private CardKind(String code) {
        this.code = code;
    }

    public static CardKind of(char code) {
        for (CardKind kind : values()) {
            if (kind.code.equals(String.valueOf(code))) {
                return kind;
            }
        }
        throw new RuntimeException("Invalid kind of card: " + code);
    }
}
