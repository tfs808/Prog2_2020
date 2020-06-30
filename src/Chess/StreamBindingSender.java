package Chess;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamBindingSender implements ChessSender {
    private DataOutputStream dos;

    public StreamBindingSender(OutputStream outputStream) {
        dos = new DataOutputStream(outputStream);
    }

    @Override
    public void sendDice(int random) throws IOException {
        dos.writeInt(Kommando.THROW);
        dos.writeInt(random);
    }

    @Override
    public void sendMove(int fromX, int fromY, int toX, int toY) throws IOException {
        dos.writeInt(Kommando.MOVE);
        dos.writeInt(fromX);
        dos.writeInt(fromY);
        dos.writeInt(toX);
        dos.writeInt(toY);
    }

    @Override
    public void sendRochade(int fromX, int fromY) throws IOException {
        dos.writeInt(Kommando.ROCHADE);
        dos.writeInt(fromX);
        dos.writeInt(fromY);
    }

    @Override
    public void sendAbandon() throws IOException, StatusException {
        dos.writeInt(Kommando.ABANDON);
    }

    @Override
    public void sendCheckMate() throws IOException, StatusException {
        dos.writeInt(Kommando.CHECKMATE);
    }
/*
    @Override
    public void sendNewGame() throws IOException, StatusException {
        dos.writeInt(Kommando.NEWGAME);
    }

    @Override
    public void sendAcceptance(int response) throws StatusException {

    }

    @Override
    public void sendError(String errorMessage) throws StatusException {

    }
 */
}
