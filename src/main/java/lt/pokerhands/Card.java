package lt.pokerhands;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final CardValue value;
    private final CardKind kind;

    public Card(CardValue value, CardKind kind) {
        this.value = value;
        this.kind = kind;
    }

    public CardKind getKind() {
        return kind;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.name() + " of " + kind.name();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, kind);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return this.value == other.value && this.kind == other.kind;
    }

    @Override
    public int compareTo(Card o) {
        return o == null ? 1 : this.value.compareTo(o.value);
    }

}
