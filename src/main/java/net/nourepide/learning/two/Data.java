package net.nourepide.learning.two;

class Data<F, S> {
    private F first;
    private S second;

    public Data(F first, S password) {
        this.first = first;
        this.second = password;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }
}