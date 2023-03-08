package e2;

import java.util.Set;

public interface Grid {
    void placeMines(int mines);

    Set<Cell> listOfCellsWithMines();

    boolean canBeHit(Pair<Integer, Integer> positionCell);

    void hit(Pair<Integer, Integer> positionCell);

    boolean isWinner();

    boolean isLoser();
}
