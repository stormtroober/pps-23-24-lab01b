package e1;

public class Context{
    private PieceStrategy pieceStrategy;

    public void setStrategy(final PieceStrategy strategy){
        this.pieceStrategy = strategy;
    }

    public boolean hit(Pair<Integer,Integer> piecePositionToHit, Pair<Integer, Integer> movingPosition){
        return pieceStrategy.hit(piecePositionToHit, movingPosition);
    }

    public Pair<Integer, Integer> getPiecePosition(){
        return pieceStrategy.getPiecePosition();
    }
}
