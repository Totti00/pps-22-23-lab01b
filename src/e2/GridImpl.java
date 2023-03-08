package e2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridImpl implements Grid {
    private final int size;
    private final Set<Cell> cells = new HashSet<>();
    private boolean gameFinshed;

    public GridImpl(int size) {
        this.size = size;
        initializeCells();
    }

    private void initializeCells() {
        IntStream.range(0, this.size).forEach(i -> {
            IntStream.range(0, this.size).forEach(j -> {
                this.cells.add(new CellImpl(new Pair<>(i, j)));
            });
        });
    }

    @Override
    public void placeMines(int mines) {
        IntStream.range(0, mines).forEach(i -> {
            this.cells.stream().filter(cell -> !cell.hasMine()).skip((int) (cells.size() * Math.random())).findAny().ifPresent(Cell::setMine);
        });
    }

    @Override
    public Set<Cell> listOfCellsWithMines() {
        return this.cells.stream().filter(Cell::hasMine).collect(Collectors.toSet());
    }

    @Override
    public boolean canBeHit(Pair<Integer, Integer> positionCell) {
        Cell cell = getPositionCell(positionCell);
        if (cell != null)
            return cell.canBeHit();
        return false;
    }

    @Override
    public void hit(Pair<Integer, Integer> positionCell) {
        Cell cell = getPositionCell(positionCell);
        cell.hit();
        if (cell.hasMine())
            gameFinshed = true;
    }

    @Override
    public boolean isWinner() {
        return this.cells.stream().noneMatch(Cell::hasMine);
    }

    @Override
    public boolean isLoser() {
        return gameFinshed;
    }

    private Cell getPositionCell(Pair<Integer, Integer> positionCell) {
        return this.cells.stream().filter(c -> c.getPosition().equals(positionCell)).findAny().orElse(null);
    }
}
