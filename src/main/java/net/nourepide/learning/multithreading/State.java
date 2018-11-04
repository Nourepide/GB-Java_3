package net.nourepide.learning.multithreading;

/**
 * Contains a reference for A, B and C letters
 * Has overridden toString for get a char of state
 */
public enum State {
    A_REFERENCE('A'),
    B_REFERENCE('B'),
    C_REFERENCE('C');

    private final char value;

    State(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
