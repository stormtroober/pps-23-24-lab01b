package e1;

public interface PieceStrategy {

    boolean hit(Pair<Integer,Integer> piecePositionToHit, Pair<Integer, Integer> movingPosition);

    Pair<Integer, Integer> getPiecePosition();
}
