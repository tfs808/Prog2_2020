package Chess;

import java.io.IOException;

public class ChessEngine implements ChessReceive, ChessSender {
    private ChessStatus status;

    public ChessEngine() {
        this.status = ChessStatus.START;
    }

    @Override
    public void receiveDice(int random) throws StatusException {
        if(this.status != ChessStatus.START) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveMove(int fromX, int fromY, int toX, int toY) throws StatusException{
        if (this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveMovePawnRule(int fromX, int fromY, int toX, int toY, int FigureType) throws IOException, StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveRochade(int fromX, int fromY) throws IOException, StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveAbandon() throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveMatt() throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void receiveError(String errorMessage) throws StatusException {
        if(this.status != ChessStatus.PASSIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendDice(int random) throws IOException, StatusException {
        if(this.status != ChessStatus.START) {
            throw new StatusException();
        }
    }

    @Override
    public void sendMove(int fromX, int fromY, int toX, int toY) throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendMovePawnRule(int fromX, int fromY, int toX, int toY, int figureType) throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendRochade(int fromX, int fromY) throws IOException, StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendAbandon() throws StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendMatt() throws StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }

    @Override
    public void sendError(String errorMessage) throws StatusException {
        if (this.status != ChessStatus.ACTIVE) {
            throw new StatusException();
        }
    }
}