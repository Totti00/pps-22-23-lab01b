package e1.pieces;

public class Knight extends Pair<Integer, Integer> {

    public Knight(Pair<Integer, Integer> position) {
        super(position.getX(), position.getY());
    }

    public boolean equals(Object pawn) {
        if (!(pawn instanceof Pair<?,?>))
            return false;
        return this.getY().equals(((Pair<?,?>) pawn).getY()) && this.getX().equals(((Pair<?,?>) pawn).getX());
    }
}
