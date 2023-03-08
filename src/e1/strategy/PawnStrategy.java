package e1.strategy;

import e1.Pair;
import e1.strategy.GameStrategy;

public class PawnStrategy implements GameStrategy {

    @Override
    public boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight) {
        return false;
    }

}
