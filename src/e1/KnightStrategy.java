package e1;

public class KnightStrategy implements GameStrategy{

    @Override
    public boolean canDoMove(int x, int y) {
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }

    @Override
    public boolean isALegalMovement(int x, int y, int size) {
        if (x<0 || y<0 || x >= size || y >= size) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

}
