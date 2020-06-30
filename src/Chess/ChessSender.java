package Chess;

import java.io.IOException;

public interface ChessSender {
    /**
     * allowed in status START
     * @throws IOException
     * @param random
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
     * @throws IOException
     * @throws StatusException
     */
    void sendRochade(int fromX, int fromY) throws IOException, StatusException;

    /**
     * allowed in status ACTIVE, player gives up, ends game
     * @throws StatusException
     */
    void sendAbandon() throws IOException, StatusException;

    /**
     * allowed in status ACTIVE, ends game
     * @throws StatusException
     */
    void sendCheckMate() throws IOException, StatusException;
/*
    /**
     * sends request for new game or closes game
     * @throws StatusException
     *
    void sendNewGame() throws IOException, StatusException;
*/
/*
    /**
     * shows acceptance of matt
     * @param response
     * @throws StatusException
     *
    void sendAcceptance(int response) throws StatusException;
*/
/*
    /**
     * allowed in status ACTIVE, ends game
     * @param errorMessage
     * @throws StatusException
     *
    void sendError(String errorMessage) throws StatusException;
 */
}