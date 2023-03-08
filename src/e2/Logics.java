package e2;

import java.util.Set;

public interface Logics {

    void placeMines(int mines);

    Set<Cell> getCellsWithMines();

    boolean hit(Pair<Integer, Integer> posCellWithMine);

    boolean checkWin();

    boolean hasFlag(Pair<Integer, Integer> posCell);

    void removeFlag(Pair<Integer, Integer> pos);

    void placeFlag(Pair<Integer, Integer> pos);
}
