package model;

public enum GameSymbol {
    X, O, EMPTY;

    @Override
    public String toString() {
        switch(this) {
            case X: return "X";
            case O: return "O";
            case EMPTY: return " ";
            default: throw new IllegalArgumentException();
        }
    }
}

