package Chess;

import java.io.IOException;
import java.util.Random;

public class ChessEngine implements ChessReceive {
    public static final int UNDEFINED_DICE = -1;
    private final ChessSender sender;

    ChessBoard board = new ChessBoard();

    private ChessStatus status;
    private int sentDice = UNDEFINED_DICE;
    private int receivedDice;

    public ChessEngine(ChessSender sender) {
        this.status = ChessStatus.START;
        this.sender = sender;
        this.board.newBoard();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                  get/set, other methods                                       //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ChessStatus getStatus() {
        return status;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public void setStatus(ChessStatus status) {
        this.status = status;
    }

    public void decide() throws StatusException {
        if (this.status != ChessStatus.DICE_RECEIVED) {
            throw new StatusException();
        }
        System.out.println("Deine Zahl: " + sentDice + ", Gegner: " + receivedDice);
        if (receivedDice > sentDice) {
            System.out.println("Gegner beginnt.");
            status = ChessStatus.PASSIVE;
        } else if (receivedDice < sentDice) {
            System.out.println("Du beginnst.");
            status =  ChessStatus.ACTIVE;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          remote engine support                                                //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void receiveDice(int random) throws StatusException {
        if(this.status != ChessStatus.DICE_SENT) {
            throw new StatusException();
        }
        this.receivedDice = random;
        status = ChessStatus.DICE_RECEIVED;
        decide();
    }

    @Override
    public void receiveMove(int fromX, int fromY, int toX, int toY) throws StatusException {
        if (this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
        System.out.println("Zug des Gegner: \n Von: " + fromX + ", " + fromY + " Nach: " + toX + ", " + toY);
        board.set(fromX, fromY, toX, toY);
        board.print();
        this.status = ChessStatus.ACTIVE;
    }

    @Override
    public void receiveRochade(int fromX, int fromY) throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
        System.out.println("Der Gegner macht einen Rochade Zug. \n Von: " + fromX + ", " + fromY);
        board.setRochade(fromX, fromY);
        board.print();
        this.status = ChessStatus.ACTIVE;
    }

    @Override
    public void receiveAbandon() throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
        System.out.println("Der Gegenspieler hat aufgegebem.");
        this.status = ChessStatus.END;
    }

    @Override
    public void receiveCheckMate() throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
        System.out.println("Schachmatt. Der Gegner hat gewonnen");
        this.status = ChessStatus.END;
    }

/*
    @Override
    public void receiveNewGame() throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
        System.out.println("Neues Spiel startet...");
        this.status = ChessStatus.START;
    }

    @Override
    public void receiveAcceptance(int response) throws StatusException {
        if (this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }


    }

    @Override
    public void receiveError(String errorMessage) throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }

        //TCP
    }
*/
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          user interface support                                                //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void sendDice() throws IOException, StatusException {
        if(this.status != ChessStatus.START) {
            throw new StatusException();
        }
        Random rndm = new Random();
        sentDice = rndm.nextInt();
        sender.sendDice(sentDice);
        this.status = ChessStatus.DICE_SENT;
    }

    public void sendMove(int fromX, int fromY, int toX, int toY) throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
        board.set(fromX, fromY, toX, toY);
        board.print();
        sender.sendMove(fromX, fromY, toX, toY);
        this.status = ChessStatus.PASSIVE;
    }

    public void sendRochade(int fromX, int fromY) throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
        board.setRochade(fromX, fromY);
        board.print();
        sender.sendRochade(fromX, fromY);
        this.status = ChessStatus.PASSIVE;
    }

    public void sendAbandon() throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
        sender.sendAbandon();
        System.out.println("Du hast aufgegeben.");
        this.status = ChessStatus.END;
    }

    public void sendCheckMate() throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
        sender.sendCheckMate();
        System.out.println("Schachmatt. Du hast gewonnen.");
        this.status = ChessStatus.END;
    }

/*
    public void sendNewGame() throws IOException, StatusException {
        if (this.status != ChessStatus.END) {
            throw new StatusException();
        }
        sender.sendNewGame();
        System.out.println("Neues Spiel startet...");
        this.status = ChessStatus.START;
    }

    @Override
    public void sendAcceptance(int response) throws StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }

        //TCP
    }

    @Override
    public void sendError(String errorMessage) throws StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }

        //TCP
    }
 */
}