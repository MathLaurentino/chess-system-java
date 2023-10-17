package boardgame;

public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces; // a 2D array to hold the pieces on the board


    // -------- CONSTRUCTOR -------- //

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }



    // -------- METHODS -------- //

    public Piece getPiece(int row, int column) {
        if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
        return pieces[row][column];
    }
    public Piece getPiece(Position position) {
        if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
        return pieces[position.getRow()][position.getColumn()];
    }


    /**
     * Places a piece at the specified position on the board.
     *
     * @param piece    the piece to be placed on the board
     * @param position the position where the piece will be placed
     * @throws BoardException if there is already a piece at the specified position
     */
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
        piece.position = position;
        pieces[position.getRow()][position.getColumn()] = piece;
    }


    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }


    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
        return getPiece(position) != null;
    }



    // -------- GETTERS AND SETTERS -------- //

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
     
}