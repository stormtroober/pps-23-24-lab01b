package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final Random random = new Random();
	private final int size;
	private final PieceStrategy knight;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = randomEmptyPosition();
		knight = new KnightStrategy(randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight){
		this.size = size;
		this.pawn = pawn;
		this.knight = new KnightStrategy(knight);
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return knight.hit(pawn, new Pair<Integer,Integer>(row, col));
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPiecePosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	public Pair<Integer, Integer> getKnightPosition(){
		return knight.getPiecePosition();
	}

	public Pair<Integer, Integer> getPawnPosition(){
		return pawn;
	}
}
