package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final GameStrategy knightStrategy;
	 
    public LogicsImpl(int size, GameStrategy knightStrategy){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
		this.knightStrategy = knightStrategy;
    }

	protected LogicsImpl(int size, GameStrategy knightStrategy, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
		this.knightStrategy = knightStrategy;
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		knightStrategy.isALegalMovement(row, col, size);
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (knightStrategy.canDoMove(x, y)) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return pawn;
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return knight;
	}

	public int getSize() {
		return size;
	}
}
