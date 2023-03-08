package e1.strategy;

import e1.pieces.Pair;

public class PawnStrategy implements GameStrategy {

    @Override
    public boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight) {
        return false;
    }

}
