package e2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridImpl implements Grid {
    private final int size;
    private final Set<Cell> cells = new HashSet<>();

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
        prova();                                                                //DEBITO TECNICO
        return this.cells.stream().filter(Cell::hasMine).collect(Collectors.toSet());
    }





    private void prova() {
        this.cells.stream().filter(Cell::hasMine).forEach(cell -> {
            System.out.println("La posizione è x: " + cell.getPosition().getX() + " e y: " + cell.getPosition().getY());
        });
    }
}
