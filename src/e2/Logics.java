package e2;

import java.util.Set;

public interface Logics {

    void placeMines(int mines);

    Set<Cell> getCellsWithMines();

    boolean hit(Pair<Integer, Integer> posCellWithMine);

    boolean checkWin();

    boolean checkLost();
}
