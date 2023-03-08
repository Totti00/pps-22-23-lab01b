package e1;

import e1.factory.GameFactory;
import e1.strategy.GameStrategy;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final GameStrategy knightStrategy;

    public LogicsImpl(int size, GameFactory factory){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
		this.knightStrategy = factory.createKnightStrategy();
    }

	protected LogicsImpl(int size, GameFactory factory, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
		this.knightStrategy = factory.createKnightStrategy();
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (this.knightStrategy.canMove(new Pair<>(row, col), size, this.knight)) {
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
}
