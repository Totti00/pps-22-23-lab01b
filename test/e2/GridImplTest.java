package e2;

import e2.Model.Cell;
import e2.Model.Grid;
import e2.Model.GridImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GridImplTest {

    public static final int SIZE = 7;
    public static final int MINES = 5;
    private Grid grid;

    @BeforeEach
    void setUp() {
        this.grid = new GridImpl(SIZE);
    }

    @Test
    void testCountCells() {
        assertEquals(SIZE * SIZE, this.grid.getCells().size());
    }

    @Test
    void testCountMines() {
        this.grid.placeMines(MINES);
        assertEquals(MINES, this.grid.listOfCellsWithMines().size());
    }

    @Test
    void testHit() {
        this.grid.placeMines(MINES);
        this.grid.hit(this.grid.listOfCellsWithMines().stream().findAny().get().getPosition());
        assertFalse(this.grid.listOfCellsWithMines().stream().allMatch(cell -> cell.canBeHit()));
    }

    @Test
    void testCheckMinesWithFlag() {
        this.grid.placeMines(MINES);
        Pair<Integer, Integer> posMine = this.grid.listOfCellsWithMines().stream().findAny().get().getPosition();
        assertTrue(this.grid.hasMine(posMine));
        this.grid.placeFlag(posMine);
        assertTrue(this.grid.hasFlag(posMine));
        this.grid.removeFlag(posMine);
        assertFalse(this.grid.hasFlag(posMine));
    }

    @Test
    void testAdjacentCells() {
        this.grid.placeMines(MINES);
        Set<Cell> adjacentCells = this.grid.getAdjacentCells(this.grid.listOfCellsWithMines().stream().findAny().get().getPosition());
        assertTrue(adjacentCells.size() >= 5);
    }


}