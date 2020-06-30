package Chess;

import java.io.IOException;

public interface ChessReceive {
    /**
     * allowed in status START, leads to active or passive
     * @param random
     * @throws IOException
     */
    void receiveDice(int random) throws StatusException;

    /**
     * allowed in status PASSIVE
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @throws IOException
     */
    void receiveMove(int fromX, int fromY, int toX, int toY) throws StatusException;


    /**
     * allowed in status PASSIVE
     * @param fromX
     * @param fromY
     * @throws IOException
     * @throws StatusException
     */
    void receiveRochade(int fromX, int fromY) throws StatusException;

    /**
     * allowed in status PASSIVE, player gives up, ends game
     * @throws StatusException
     * @param
     */
    void receiveAbandon() throws StatusException;

    /**
     * allowed in status PASSIVE
     * @throws StatusException
     */
    void receiveCheckMate() throws StatusException;
/*
    /**
     * gets response to new game request, closes game
     * @throws StatusException
     *
    void receiveNewGame() throws StatusException;
*/
/*
    /**
     * receive acceptance of matt
     * @param response
     * @throws StatusException
     *
    void receiveAcceptance(int response) throws StatusException;
*/
/*
    /**
     * allowed in status PASSIVE, ends game
     * @param errorMessage
     * @throws StatusException
     *
    void receiveError(String errorMessage) throws StatusException;
 */
}