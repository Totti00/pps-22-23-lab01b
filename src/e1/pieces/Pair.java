package e1.pieces;

/*
 * A standard generic Pair<X,Y>, with getters, hashCode, equals, and toString well implemented. 
 */

import java.util.Random;

public class Pair<X,Y> {
	private Pair<Integer, Integer> pawn;
	private final Random random = new Random();
	private X x;
	private Y y;
	
	public Pair(X x, Y y) {
		super();
		this.x = x;
		this.y = y;
	}

	public X getX() {
		return x;
	}

	public Y getY() {
		return y;
	}

	public void setPos(Pair<X, Y> newPos) {
		this.x = newPos.getX();
		this.y = newPos.getY();
	}

	private void setPawn(Pair<Integer, Integer> pawn) {
		if (this.pawn == null) this.pawn = pawn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

	public final Pair<Integer,Integer> randomEmptyPosition(Integer size){
		Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
		this.setPawn(pos);
		// the recursive call below prevents clash with an existing pawn
		return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition(size) : pos;
	}
}
