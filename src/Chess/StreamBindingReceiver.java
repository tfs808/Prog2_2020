package Chess;

import java.io.DataInputStream;
import java.io.IOException;

public class StreamBindingReceiver extends Thread {
    private DataInputStream dis;
    private ChessReceive receiver;

    public StreamBindingReceiver(DataInputStream dis, ChessReceive receiver) {
        this.dis = dis;
        this.receiver = receiver;
    }

    public void receiveDice() throws IOException, StatusException {
        int random = dis.readInt();
        System.out.println("Random: " + random);
        receiver.receiveDice(random);
    }

    public void receiveMove() throws IOException, StatusException {
        int fromX = dis.readInt();
        int fromY = dis.readInt();
        int toX = dis.readInt();
        int toY = dis.readInt();
        receiver.receiveMove(fromX, fromY, toX, toY);
    }

    public void receiveRochade() throws IOException, StatusException {
        int fromX = dis.readInt();
        int fromY = dis.readInt();
        receiver.receiveRochade(fromX, fromY);
    }

    public void receiveAbandon() throws StatusException {
        receiver.receiveAbandon();
    }

    public void receiveCheckmate() throws StatusException {
        receiver.receiveCheckMate();
    }

/*
    public void receiveNewGame() throws StatusException {
        receiver.receiveNewGame();
    }
*/

    @Override
    public void run() {
        boolean again = true;
        while (again) {
            try {
                int cmd = dis.readInt();
                System.out.println("reading command: " + cmd);
                switch (cmd) {
                    case Kommando.THROW:
                        receiveDice();
                        break;
                    case Kommando.MOVE:
                        receiveMove();
                        break;
                    case Kommando.ABANDON:
                        receiveAbandon();
                        break;
                    case Kommando.CHECKMATE:
                        receiveCheckmate();
                        break;
                    case Kommando.ROCHADE:
                        receiveRochade();
                        break;
                    /*
                    case Kommando.NEWGAME:
                        receiveNewGame();
                        break;
                     */
                    default:
                        again = false;
                        System.out.println("unknown command: " + cmd);
                }
            } catch (StatusException se) {
                System.out.println("StatusException: " + se.getLocalizedMessage());
                again = false;
            } catch (IOException ioe) {
                System.out.println("IOException: " + ioe.getLocalizedMessage());
                again = false;
            }
        }
    }

/*
    public void receiveAcceptance() throws IOException {

    }

    public void receiveError() throws IOException {

    }
}
 */
}