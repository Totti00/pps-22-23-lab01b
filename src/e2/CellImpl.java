package e2;

public class CellImpl implements Cell {
    private final Pair<Integer, Integer> posCell;
    private boolean canBeHit;
    private boolean hasMine;
    private boolean hasFlag;
    private int counterAdjacentMines;

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

    @Override
    public boolean isHit() {
        return !this.canBeHit;
    }

    @Override
    public boolean isAdjacent(Pair<Integer, Integer> posButton) {
        return (Math.abs(this.posCell.getX() - posButton.getX()) <= 1 && Math.abs(this.posCell.getY() - posButton.getY()) <= 1
                && !(this.posCell.getX().equals(posButton.getX()) && this.posCell.getY().equals(posButton.getY())));
    }

    @Override
    public void incrementAdjacentMines() {
        this.counterAdjacentMines = this.counterAdjacentMines + 1;
    }

    @Override
    public int getAdjacentMines() {
        return this.counterAdjacentMines;
    }
}
