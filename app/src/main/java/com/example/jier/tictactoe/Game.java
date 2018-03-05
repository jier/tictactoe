package com.example.jier.tictactoe;

import android.util.Log;

import java.io.Serializable;

import javax.xml.parsers.FactoryConfigurationError;

/**
 * Created by jier on 15-2-18.
 */

public class Game implements Serializable {
    final private  int BOARD_SIZE = 3;
    private Tile[][] board;
    private GameState state;
    private Boolean playerOneTurn;
    private Boolean playerOne;
    private Boolean playerTwo;
    private int movesPlayed;
    private int countCross;
    private int countCircle;
    private Boolean gameOver;

    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        state = GameState.IN_PROGRESS;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Tile.BLANK;
            }
        }
        playerOneTurn = true;
        playerOne = false;
        playerTwo = false;
        gameOver = false;
        countCross = 0;
        countCircle = 0;
    }

    public Tile draw(int row, int column) {
        Tile value_position = board[row][column]; // retrieve current value of board position
        finishedGame(value_position, movesPlayed, state);
        if (gameOver) {
            System.out.println("i am over");
            return Tile.INVALID;
        }
        if (value_position == Tile.BLANK) {
            if (playerOneTurn) {
                playerOneTurn = false;
                board[row][column] = Tile.CROSS;
                value_position = board[row][column];
                state  = GameState.PLAYER_ONE ;
                System.out.println("After assigning state first");
                System.out.println(state);
                finishedGame(value_position,countCross,state);
            } else {
                playerOneTurn = true;
                board[row][column] = Tile.CIRCLE;
                value_position = board[row][column];
                state = GameState.PLAYER_TWO;
                System.out.println("After assigning state second");
                System.out.println(state);
                finishedGame(value_position,countCircle,state);
            }
            System.out.println(countCircle);
            System.out.println(countCross);
            movesPlayed++;
            System.out.println(movesPlayed);
            System.out.println(value_position);
            finishedGame(value_position,movesPlayed,state);
            if (movesPlayed == 10) {
                System.out.println("all played");
                gameOver = true;
                return Tile.INVALID;
            }
        } else {
                return  Tile.INVALID;
        }
        return value_position;
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    private void tileCount() {
        int blank = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == Tile.CROSS) {
                    countCross++;
                }else if (board[i][j] == Tile.CIRCLE) {
                    countCircle++;
                }else {
                    if (board[i][j] == Tile.BLANK) {
                        blank++;
                    }
                }
            }
        }
    }

    public void finishedGame(Tile tilePos, int numbPlayed, GameState player) {
        checkHorizontal( numbPlayed, tilePos, player);
//        checkVertical(false, numbPlayed, tilePos, player);
//        checkDiagonal(false,numbPlayed, tilePos, player);
    }

    public boolean checkHorizontal(int numbPlayed,  Tile tile, GameState player) {
        boolean inArow = false;
        tileCount();
        for (int i = 0 ; i < BOARD_SIZE ; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ( board[i][j] == tile) {
                    if (countCross == 3  && numbPlayed == 9) {
                        playerOne = true;
                        inArow = true;
                        gameOver = true;
                    }
                }
            }
        }
        return inArow;
    }
//    public boolean checkVertical(boolean inArow, int numbPlayed,  Tile tile, GameState player) {
//        for (int i = 0 ; i < BOARD_SIZE ; i++) {
//            for (int j = 0; j < BOARD_SIZE; j++) {
//                if (board[i][0] == tile ) {
//                    switch (player) {
//                        case IN_PROGRESS:
//                            break;
//                        case PLAYER_ONE:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case PLAYER_TWO:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case DRAW:
//                            break;
//                    }
//
//                }else if (board[i][1] == tile ) {
//                    switch (player) {
//                        case IN_PROGRESS:
//                            break;
//                        case PLAYER_ONE:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case PLAYER_TWO:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case DRAW:
//                            break;
//                    }
//                }else if (board[i][2] == tile ) {
//                    switch (player) {
//                        case IN_PROGRESS:
//                            break;
//                        case PLAYER_ONE:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case PLAYER_TWO:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case DRAW:
//                            break;
//                    }
//                }else {
//                    break;
//                }
//            }
//        }
//        return  inArow;
//    }
//
//    public boolean checkDiagonal(boolean inArow, int numbPlayed,  Tile tile, GameState player) {
//        for (int i = 0; i < BOARD_SIZE; i++) {
//            for (int j = 0; j < BOARD_SIZE; j++) {
//                if (board[i][j] == tile) {
//                    switch (player) {
//                        case IN_PROGRESS:
//                            break;
//                        case PLAYER_ONE:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case PLAYER_TWO:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case DRAW:
//                            break;
//                    }
//                } else if (board[2-i][2-j] == tile) {
//                    switch (player) {
//                        case IN_PROGRESS:
//                            break;
//                        case PLAYER_ONE:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case PLAYER_TWO:
//                            gameOver = true;
//                            inArow = true;
//                            break;
//                        case DRAW:
//                            break;
//                    }
//                }else {
//                    break;
//                }
//            }
//        }
//        return inArow;
//    }

    public boolean getGameMatch() {
        return gameOver;
    }

    public boolean getFirstPlayerStatus() {
        return playerOne;
    }
    public boolean getSecondPlayerStatus() {
        return playerTwo;
    }
}
