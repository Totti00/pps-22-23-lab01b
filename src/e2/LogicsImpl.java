package e2;

import java.util.Set;

public class LogicsImpl implements Logics {

    private int size;
    private Grid grid;


    public LogicsImpl(int size) {
        this.size = size;
        this.grid = new GridImpl(size);
    }

    @Override
    public void placeMines(int mines) {
        this.grid.placeMines(mines);
    }

    @Override
    public Set<Cell> getCellsWithMines() {
        return this.grid.listOfCellsWithMines();
    }
}
