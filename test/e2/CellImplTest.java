package e2;

import e2.Model.Cell;
import e2.Model.CellImpl;
import e2.Model.CellType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CellImplTest {
    private Cell cell;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(new Pair<>(0, 0), CellType.EMPTY);
    }

    @Test
    void testHasMine() {
        assertFalse(this.cell.hasMine());
    }

    @Test
    void testSetMine() {
        this.cell.setMine();
        assertTrue(this.cell.hasMine());
    }

    @Test
    void testCanBeHit() {
        assertTrue(this.cell.canBeHit());
        this.cell.hit();
        assertFalse(this.cell.canBeHit());
    }

    @Test
    void testIsAdjacent() {
        assertTrue(this.cell.isAdjacent(new Pair<>(0, 1)));
        assertTrue(this.cell.isAdjacent(new Pair<>(1, 0)));
        assertTrue(this.cell.isAdjacent(new Pair<>(1, 1)));
        assertFalse(this.cell.isAdjacent(new Pair<>(2, 2)));
    }

}