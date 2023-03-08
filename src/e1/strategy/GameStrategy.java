package e1.strategy;

import e1.pieces.Pair;

public interface GameStrategy {

    boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight);
}
