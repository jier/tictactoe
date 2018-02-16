package com.example.jier.tictactoe;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import java.io.Serializable;


public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState.getSerializable("game")) {
//            game = (Game) savedInstanceState.getSerializable("game");
            super.onRestoreInstanceState(savedInstanceState);
            System.out.println("hier");

        }else {
        game = new Game();
        }
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("game", game);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        game = (Game) savedInstanceState.getSerializable("game");
//        updateUI(game);
        GridLayout layout = findViewById(R.id.grid);
        Tile tile = null;
        Button button = null;
        for (int i = 0 ; i < layout.getChildCount(); i++) {
            button = (Button) layout.getChildAt(i);
            tile = game.getTile(i/3,i%3);
            System.out.println(layout.getChildAt(i));
            switch (tile) {
                case CROSS:
                    button.setText("X");
                    break;
                case CIRCLE:
                    button.setText("O");
                    break;
                case BLANK:
                    button.setText(" ");
                    break;
                case INVALID:
                    break;
            }
        }
    }

    public void updateUI(Game game) {
        GridLayout layout = findViewById(R.id.grid);
        Tile tile = null;
        Button button = null;

        for (int i = 0 ; i < layout.getChildCount(); i++) {
            button = (Button) layout.getChildAt(i);
            tile = game.getTile(i/3,i%3);
            System.out.println(tile);
            switch (tile) {
                case CROSS:
                    button.setText("X");
                    break;
                case CIRCLE:
                    button.setText("O");
                    break;
                case BLANK:
                    button.setText("Hallo");
                    break;
                case INVALID:
                    break;
            }
            System.out.println("second");
            System.out.println(tile);
        }
    }
    public void tileClicked(View view) {
        GridLayout layout = findViewById(R.id.grid);
        int row = 0;
        int column = 0;
        Button button = (Button) view;
        for (int i = 0 ; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) == view) {
                row = i / 3;
                column = i % 3;
            }
        }

        Tile tile = game.draw(row,column);
        switch (tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case BLANK:
                button.setText(" ");
                break;
            case INVALID:
                break;
        }
    }


    public void resetClicked(View view) {
        game = new Game();
        updateUI(game);
    }
}
