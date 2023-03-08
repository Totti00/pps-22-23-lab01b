package e2;

public class CellImpl implements Cell {
    private final Pair<Integer, Integer> posCell;
    private boolean hasMine;

    public CellImpl(Pair<Integer, Integer> posCell) {
        this.posCell = posCell;
    }

    @Override
    public boolean hasMine() {
        return this.hasMine;
    }

    @Override
    public void setMine() {
        this.hasMine = true;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.posCell;
    }
}
