package e2;

public class CellImpl implements Cell {
    private final Pair<Integer, Integer> posCell;
    private boolean canBeHit;
    private boolean hasMine;
    private boolean hasFlag;

    public CellImpl(Pair<Integer, Integer> posCell) {
        this.canBeHit = true;
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

    @Override
    public boolean canBeHit() {
        //se ha la bandierina non può essere colpito
        return this.canBeHit;
    }

    @Override
    public void hit() {
        this.canBeHit = false;
    }

    @Override
    public boolean hasFlag() {
        return hasFlag;
    }

    @Override
    public void removeFlag() {
        this.hasFlag = false;
    }

    @Override
    public void placeFlag() {
        this.hasFlag = true;
    }
}
