package e2;

import java.util.Set;

public interface Grid {
    void placeMines(int mines);

    Set<Cell> listOfCellsWithMines();

    void hit(Pair<Integer, Integer> positionCell);

    boolean hasMine(Pair<Integer, Integer> positionCell);

    boolean hasFlag(Pair<Integer, Integer> posCell);

    void removeFlag(Pair<Integer, Integer> pos);

    void placeFlag(Pair<Integer, Integer> pos);

    Set<Cell> getCells();

    Set<Cell> getAdjacentCells(Pair<Integer, Integer> pos);
}
