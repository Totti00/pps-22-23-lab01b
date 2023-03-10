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

}