package Chess;

public class ChessBoard implements ChessBoardInterface {

    public static final int dim = 8;

    private ChessBoardFieldStatus[][] b = new ChessBoardFieldStatus[dim][dim];

    @Override
    public void newBoard() {
        for (int i = 0; i < b.length; i++) {
            b[i][1] = ChessBoardFieldStatus.PAWN_BLACK;
        }
        for (int i = 0; i < b.length; i++) {
            b[i][6] = ChessBoardFieldStatus.PAWN_WHITE;
        }
        b[0][0] = ChessBoardFieldStatus.ROOK_BLACK;
        b[7][0] = ChessBoardFieldStatus.ROOK_BLACK;
        b[0][7] = ChessBoardFieldStatus.ROOK_WHITE;
        b[7][7] = ChessBoardFieldStatus.ROOK_WHITE;
        b[1][0] = ChessBoardFieldStatus.KNIGHT_BLACK;
        b[6][0] = ChessBoardFieldStatus.KNIGHT_BLACK;
        b[1][7] = ChessBoardFieldStatus.KNIGHT_WHITE;
        b[6][7] = ChessBoardFieldStatus.KNIGHT_WHITE;
        b[2][0] = ChessBoardFieldStatus.BISHOP_BLACK;
        b[5][0] = ChessBoardFieldStatus.BISHOP_BLACK;
        b[2][7] = ChessBoardFieldStatus.BISHOP_WHITE;
        b[5][7] = ChessBoardFieldStatus.BISHOP_WHITE;
        b[3][0] = ChessBoardFieldStatus.QUEEN_BLACK;
        b[3][7] = ChessBoardFieldStatus.QUEEN_WHITE;
        b[4][0] = ChessBoardFieldStatus.KING_BLACK;
        b[4][7] = ChessBoardFieldStatus.KING_WHITE;
        for(int k = 0; k < b.length; k++) {
            for (int h = 3; h < 5; h++) {
                b[k][h] = ChessBoardFieldStatus.EMPTY;
            }
        }
    }

    @Override
    public void set(int fromX, int fromY, int toX, int toY) {
        b[toX-1][toY-1] = b[fromX-1][fromY-1];
        b[fromX-1][fromY-1] = ChessBoardFieldStatus.EMPTY;
    }

    @Override
    public void setRochade(int fromX, int fromY) {
        if (fromX == 1 && fromY == 1) {
            if (b[3][0] == ChessBoardFieldStatus.EMPTY && b[2][0] == ChessBoardFieldStatus.EMPTY &&
                    b[1][0] == ChessBoardFieldStatus.EMPTY) {
                b[0][0] = ChessBoardFieldStatus.EMPTY;
                b[1][0] = ChessBoardFieldStatus.KING_BLACK;
                b[2][0] = ChessBoardFieldStatus.ROOK_BLACK;
                b[4][0] = ChessBoardFieldStatus.EMPTY;
            } else {
                System.out.println("Rochade kann nicht ausgeführt werden, Figuren sind im Weg.");
            }
        }
        if (fromX == 8 && fromY == 1) {
            if (b[5][0] == ChessBoardFieldStatus.EMPTY && b[6][0] == ChessBoardFieldStatus.EMPTY) {
                b[7][0] = ChessBoardFieldStatus.EMPTY;
                b[5][0] = ChessBoardFieldStatus.ROOK_BLACK;
                b[6][0] = ChessBoardFieldStatus.KING_BLACK;
                b[4][0] = ChessBoardFieldStatus.EMPTY;
            } else {
                System.out.println("Rochade kann nicht ausgeführt werden, Figuren sind im Weg.");
            }
        }
        if (fromX == 1 && fromY == 8) {
            if (b[1][7] == ChessBoardFieldStatus.EMPTY && b[2][7] == ChessBoardFieldStatus.EMPTY &&
                    b[3][7] == ChessBoardFieldStatus.EMPTY) {
                b[0][7] = ChessBoardFieldStatus.EMPTY;
                b[2][7] = ChessBoardFieldStatus.ROOK_WHITE;
                b[1][7] = ChessBoardFieldStatus.KING_WHITE;
                b[4][7] = ChessBoardFieldStatus.EMPTY;
            } else {
                System.out.println("Rochade kann nicht ausgeführt werden, Figuren sind im Weg.");
            }
        }
        if (fromX == 8 && fromX == 8) {
            if (b[6][7] == ChessBoardFieldStatus.EMPTY && b[5][7] == ChessBoardFieldStatus.EMPTY) {
                b[4][7] = ChessBoardFieldStatus.EMPTY;
                b[7][7] = ChessBoardFieldStatus.EMPTY;
                b[6][7] = ChessBoardFieldStatus.KING_WHITE;
                b[5][7] = ChessBoardFieldStatus.ROOK_WHITE;
            } else {
                System.out.println("Rochade kann nicht ausgeführt werden, Figuren sind im Weg.");
            }
        }
    }

    @Override
    public ChessBoardFieldStatus[][] getChessBoard() {
        return b;
    }

    @Override
    public void print() {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                switch (b[i][j]) {
                    case PAWN_WHITE:
                        System.out.println("|_WB_|");
                        break;
                    case PAWN_BLACK:
                        System.out.println("|_SB_|");
                        break;
                    case ROOK_WHITE:
                        System.out.println("|_WT_|");
                        break;
                    case ROOK_BLACK:
                        System.out.println("|_BT_|");
                        break;
                    case KING_WHITE:
                        System.out.println("|_WP_|");
                        break;
                    case KING_BLACK:
                        System.out.println("|_BP_|");
                        break;
                    case BISHOP_WHITE:
                        System.out.println("|_WS_|");
                        break;
                    case BISHOP_BLACK:
                        System.out.println("|_SS_|");
                        break;
                    case QUEEN_WHITE:
                        System.out.println("|_WQ_|");
                        break;
                    case QUEEN_BLACK:
                        System.out.println("|_BQ_|");
                        break;
                    case KNIGHT_WHITE:
                        System.out.println("|_WK_|");
                        break;
                    case KNIGHT_BLACK:
                        System.out.println("|_SK_|");
                    case EMPTY:
                        System.out.println("|____|");
                }
            }
        }
    }
}
