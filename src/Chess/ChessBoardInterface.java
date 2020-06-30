package Chess;

public interface ChessBoardInterface {

    /**
     * create new Chessboard of type ChessFigure
     */
    void newBoard();

    /**
     * set figure from x to y
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     */
    void set(int fromX, int fromY, int toX, int toY);

    /**
     * Rochade move, switches Rook and King
     * @param fromX position of rook
     * @param fromY position of rook
     */
    void setRochade(int fromX, int fromY);

    /**
     * get ChessBoard
     * @return
     */
    ChessBoardFieldStatus[][] getChessBoard();

    /**
     * prints ChessBoard
     */
    void print();
}
