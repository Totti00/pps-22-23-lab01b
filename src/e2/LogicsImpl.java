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

    @Override
    public boolean hit(Pair<Integer, Integer> positionCell) {
        if (!(positionCell.getX() < 0 || positionCell.getX() >= this.size || positionCell.getY() < 0 || positionCell.getY() >= this.size)) {
            if (this.grid.canBeHit(positionCell)) {
                this.grid.hit(positionCell);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkWin() {
        return this.grid.isWinner();
    }

    @Override
    public boolean checkLost() {
        return this.grid.isLoser();
    }
}
