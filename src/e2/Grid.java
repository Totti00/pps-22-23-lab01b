package e2;

import java.util.Set;

public interface Grid {
    void placeMines(int mines);

    Set<Cell> listOfCellsWithMines();
}
