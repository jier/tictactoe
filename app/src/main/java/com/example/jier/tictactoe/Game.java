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
        if (value_position == Tile.BLANK) {
            if (playerOneTurn) {
                playerOneTurn = false;

                board[row][column] = Tile.CROSS;
                state  = GameState.PLAYER_ONE ;
                movesPlayed++;
                if (finishedGame(movesPlayed)) {
                    playerOne = true;
                }
                return board[row][column];
            } else {
                playerOneTurn = true;
                board[row][column] = Tile.CIRCLE;
                movesPlayed++;
                state = GameState.PLAYER_TWO;
                if (finishedGame(movesPlayed)) {
                    playerTwo = true;
                }
                return board[row][column];
            }
        } else {
            return board[row][column];
        }
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    public boolean finishedGame(int playedTile) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0 ; j < BOARD_SIZE; j++) {
                if (board[0][j] == board[i][j] && playedTile == 3 ) {
                    gameOver = true;
                }else if (board[1][j] == board[i][j] && playedTile == 3 ) {
                    gameOver = true;
                }else if (board[2][j] == board[i][j] && playedTile == 3 ) {
                    gameOver = true;
                }else if (board[i][j] == board[i][j] && playedTile == 3 ) {
                    gameOver = true;
                }
            }
        }
        return gameOver;
    }
}
