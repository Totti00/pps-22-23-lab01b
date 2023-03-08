package e1.strategy;

import e1.Pair;

public interface GameStrategy {

    boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight);
}
