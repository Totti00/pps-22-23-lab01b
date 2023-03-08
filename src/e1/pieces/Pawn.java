package e1.pieces;

public class Pawn extends Pair<Integer, Integer> {

    public Pawn(Pair<Integer, Integer> position) {
        super(position.getX(), position.getY());
    }

    public boolean equals(Object knight) {
        if (!(knight instanceof Pair<?,?>)) {
            return false;
        }
        return this.getY().equals(((Pair<?, ?>) knight).getY()) && this.getX().equals(((Pair<?, ?>) knight).getX());
    }
}
