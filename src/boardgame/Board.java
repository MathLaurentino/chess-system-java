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


    /**
     * Removes the piece at the specified position on the board.
     * @param position the position of the piece to be removed
     * @return the removed piece, or null if there is no piece at the position
     * @throws BoardException if the position is not on the board
     */
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}

        Piece aux = getPiece(position);
        if (aux == null) {
            return null;
        }
        pieces[position.getRow()][position.getColumn()] = null;

        aux.position = null;
        return aux;
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