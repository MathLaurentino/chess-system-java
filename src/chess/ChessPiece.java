package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }


    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().getPiece(position);
        return p != null && p.getColor() != color;
    }


    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }


    public Color getColor() {
        return color;
    }

    
}
