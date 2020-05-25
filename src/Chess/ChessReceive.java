package Chess;

import jdk.jshell.Snippet;

import java.io.IOException;

public interface ChessReceive {
    /**
     * allowed in status START, leads to active or passive
     * @param random
     * @throws IOException
     */
    void receiveDice(int random) throws IOException, StatusException;

    /**
     * allowed in status PASSIVE
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @throws IOException
     */
    void receiveMove(int fromX, int fromY, int toX, int toY) throws IOException, StatusException;

    /**
     * allowed in status PASSIVE
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param FigureType
     * @throws IOException
     * @throws StatusException
     */
    void receiveMovePawnRule(int fromX, int fromY, int toX, int toY, int FigureType) throws IOException, StatusException;

    /**
     * allowed in status PASSIVE
     * @param fromX
     * @param fromY
     * @throws IOException
     * @throws StatusException
     */
    void receiveRochade(int fromX, int fromY) throws IOException, StatusException;

    /**
     * allowed in status PASSIVE, player gives up, ends game
     * @throws StatusException
     */
    void receiveAbandon() throws StatusException;

    /**
     * allowed in status PASSIVE
     * @throws StatusException
     */
    void receiveMatt() throws StatusException;

    /**
     * allowed in status PASSIVE, ends game
     * @param errorMessage
     * @throws StatusException
     */
    void receiveError(String errorMessage) throws StatusException;
}