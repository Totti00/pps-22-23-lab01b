package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridImplTest {

    public static final int SIZE = 7;
    private Grid grid;

    @BeforeEach
    void setUp() {
        this.grid = new GridImpl(SIZE);
    }

    @Test
    void testCountMinesAfterHit() {
        this.grid.placeMines(5);
        Pair<Integer, Integer> posMines = this.grid.listOfCellsWithMines().stream().findAny().get().getPosition();
        Pair<Integer, Integer> posButton;
        if (posMines.getX() == SIZE - 1 && posMines.getY() == SIZE - 1) {
            posButton = new Pair<>(posMines.getX() - 1, posMines.getY() - 1);
            this.grid.hit(posButton);
        } else if (posMines.getX() == SIZE - 1) {
            posButton = new Pair<>(posMines.getX() - 1, posMines.getY());
            this.grid.hit(posButton);
        } else if (posMines.getY() == SIZE - 1) {
            posButton = new Pair<>(posMines.getX(), posMines.getY() - 1);
            this.grid.hit(posButton);
        } else {
            posButton = new Pair<>(posMines.getX() + 1, posMines.getY() + 1);
            this.grid.hit(posButton);
        }
        assertTrue(this.grid.getNumberOfAdjacentMines(posButton) >= 1);
    }
}