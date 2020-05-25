package Chess;

import java.io.IOException;

public interface ChessSender {
    /**
     * allowed in status START
     * @param random
     * @throws IOException
     */
    void sendDice(int random) throws IOException, StatusException;

    /**
     * allowed in status ACTIVE
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @throws IOException
     */
    void sendMove(int fromX, int fromY, int toX, int toY) throws IOException, StatusException;

    /**
     * allowed in status ACTIVE
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param figureType
     * @throws IOException
     * @throws StatusException
     */
    void sendMovePawnRule(int fromX, int fromY, int toX, int toY, int figureType) throws IOException, StatusException;

    /**
     * allowed in status ACTIVE
     * @param fromX
     * @param fromY
     * @throws IOException
     * @throws StatusException
     */
    void sendRochade(int fromX, int fromY) throws IOException, StatusException;

    /**
     * allowed in status ACTIVE, player gives up, ends game
     * @throws StatusException
     */
    void sendAbandon() throws StatusException;

    /**
     * allowed in status ACTIVE, ends game
     * @throws StatusException
     */
    void sendMatt() throws StatusException;

    /**
     * allowed in status ACTIVE, ends game
     * @param errorMessage
     * @throws StatusException
     */
    void sendError(String errorMessage) throws StatusException;
}