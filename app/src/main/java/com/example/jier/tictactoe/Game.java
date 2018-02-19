package com.example.jier.tictactoe;

import java.io.Serializable;

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
    }

    public Tile draw(int row, int column) {
        Tile value_position = board[row][column]; // retrieve current value of board position
        finishedGame(value_position, movesPlayed, state);
        if (gameOver) {
            return Tile.INVALID;
        }
        if (value_position == Tile.BLANK) {
            if (playerOneTurn) {
                playerOneTurn = false;
                board[row][column] = Tile.CROSS;
                value_position = board[row][column];
                state  = GameState.PLAYER_ONE ;

            } else {
                playerOneTurn = true;
                board[row][column] = Tile.CIRCLE;
                value_position = board[row][column];
                state = GameState.PLAYER_TWO;
            }
            movesPlayed++;
            finishedGame(value_position,movesPlayed,state);
            if (movesPlayed == BOARD_SIZE*BOARD_SIZE) {
                gameOver = true;
                return value_position;
            }
        } else {
//
                return  Tile.INVALID;
            }
        return value_position;
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    public void finishedGame(Tile tilePos, int numbPlayed, GameState player) {
        checkHorizontal(false, numbPlayed, tilePos, player);
        checkVertical(false, numbPlayed, tilePos, player);
        checkDiagonal(false,numbPlayed, tilePos, player);
    }

    public boolean checkHorizontal(boolean inArow, int numbPlayed,  Tile tile, GameState player) {
        for (int i = 0 ; i < BOARD_SIZE ; i++) {
            for (int j = 0 ; j < BOARD_SIZE ; j++) {
                if (board[0][j] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            inArow = true;
                            gameOver = true;
                            break;
                        case PLAYER_TWO:
                            inArow = true;
                            gameOver = true;
                            break;
                        case DRAW:
                            break;
                    }

                }else if (board[1][j] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            inArow = true;
                            gameOver = true;
                            break;
                        case PLAYER_TWO:
                            inArow = true;
                            gameOver = true;
                            break;
                    }
                }else if (board[2][j] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            inArow = true;
                            gameOver = true;
                            break;
                        case PLAYER_TWO:
                            inArow = true;
                            gameOver = true;
                            break;
                    }
                }else {
                    break;
                }
            }

        }
        return inArow;
    }
    public boolean checkVertical(boolean inArow, int numbPlayed,  Tile tile, GameState player) {
        for (int i = 0 ; i < BOARD_SIZE ; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][0] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            gameOver = true;
                            inArow = true;
                            break;
                        case PLAYER_TWO:
                            gameOver = true;
                            inArow = true;
                            break;
                        case DRAW:
                            break;
                    }

                }else if (board[i][1] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            gameOver = true;
                            inArow = true;
                            break;
                        case PLAYER_TWO:
                            gameOver = true;
                            inArow = true;
                            break;
                        case DRAW:
                            break;
                    }
                }else if (board[i][2] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            gameOver = true;
                            inArow = true;
                            break;
                        case PLAYER_TWO:
                            gameOver = true;
                            inArow = true;
                            break;
                        case DRAW:
                            break;
                    }
                }else {
                    break;
                }
            }
        }
        return  inArow;
    }

    public boolean checkDiagonal(boolean inArow, int numbPlayed,  Tile tile, GameState player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == tile && numbPlayed == BOARD_SIZE*BOARD_SIZE) {
                    switch (player) {
                        case IN_PROGRESS:
                            break;
                        case PLAYER_ONE:
                            gameOver = true;
                            inArow = true;
                            break;
                        case PLAYER_TWO:
                            gameOver = true;
                            inArow = true;
                            break;
                        case DRAW:
                            break;
                    }
                } else {
                    break;
                }
            }
        }
        return inArow;
    }

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
