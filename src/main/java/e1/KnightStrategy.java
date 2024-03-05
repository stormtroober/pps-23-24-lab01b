package e1;


public class KnightStrategy implements PieceStrategy{

    private Pair<Integer, Integer> knightPosition;

    public KnightStrategy(Pair<Integer, Integer> knightPosition){
        this.knightPosition = knightPosition;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> pawn, Pair<Integer, Integer> movingPosition) {
        // Below a compact way to express allowed moves for the knight
		int x = movingPosition.getX() - knightPosition.getX();
		int y = movingPosition.getY() - knightPosition.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			knightPosition = new Pair<>(movingPosition.getX(),movingPosition.getY());
			return pawn.equals(knightPosition);
		}
		return false;
    }

    @Override
    public Pair<Integer, Integer> getPiecePosition() {
        return knightPosition;
    }
    
}
