package com.example.xo_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvPlayer1Score;
    TextView tvPlayer2Score;
    ConstraintLayout mainConstrain;
    Button clearClick;
    int player1Score = 0;
    int player2Score = 0;
    int playCount = 0;
    String[] boardState = {"", "", "", "", "", "", "", "", ""};
    TextView edPlayer_1;
    TextView edPlayer_2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        String nameofPlayer1 = getIntent().getStringExtra("player1Name");
        String nameofPlayer2 = getIntent().getStringExtra("player2Name");
        tvPlayer1Score.setText(0 + "");
        tvPlayer2Score.setText(0 + "");
        edPlayer_1.setText(nameofPlayer1);
        edPlayer_2.setText(nameofPlayer2);
        clearClick.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                resetBoard();
                player1Score = 0;
                player2Score = 0;
                tvPlayer1Score.setText(0 + "");
                tvPlayer2Score.setText(0 + "");
                goBack();
            }
        });

    }

    private void initViews() {
        tvPlayer1Score = findViewById(R.id.et_player_1);
        tvPlayer2Score = findViewById(R.id.et_player_2);
        mainConstrain = findViewById(R.id.main);
        clearClick = findViewById(R.id.booton_clear);
        edPlayer_1 = findViewById(R.id.tv_player_1);
        edPlayer_2 = findViewById(R.id.tv_player_2);

    }

    private void goBack() {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void onClicPlayer(View view) {
        Button click = (Button) view;
        int index = Integer.parseInt(click.getTag().toString());
        if (!click.getText().toString().isEmpty()) {
            return;
        }
        if (playCount % 2 == 0) {
            click.setText("X");
            player1Score++;
            boardState[index] = "X";
            tvPlayer1Score.setText(player1Score + "");

        } else {
            click.setText("O");
            player2Score++;
            boardState[index] = "O";
            tvPlayer2Score.setText(player2Score + "");

        }
        playCount++;
        if (isWener("X")) {
            player1Score += 5;
            tvPlayer1Score.setText(player1Score + "");
            resetBoard();

        } else if (isWener("O")) {
            player2Score += 5;
            tvPlayer2Score.setText(player2Score + "");
            resetBoard();
        } else if (playCount == 9) {
            resetBoard();
        }


    }

    private void resetBoard() {
        Arrays.fill(boardState, "");
        playCount = 0;
        for (int i = 0; i < 9; i++) {
            View v = mainConstrain.findViewWithTag(i + "");
            Button b = (Button) v;
            b.setText("");
        }

    }

    private boolean isWener(String playerSaymbol) {
        for (int i = 0; i < 9; i += 3) {
            if (boardState[i].equals(playerSaymbol) &&
                    boardState[i + 1].equals(playerSaymbol) &&
                    boardState[i + 2].equals(playerSaymbol)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (boardState[i].equals(playerSaymbol) &&
                    boardState[i + 3].equals(playerSaymbol) &&
                    boardState[i + 6].equals(playerSaymbol)) {
                return true;
            }
        }
        if (boardState[0].equals(playerSaymbol) &&
                boardState[4].equals(playerSaymbol) &&
                boardState[8].equals(playerSaymbol)) {
            return true;
        } else if (boardState[2].equals(playerSaymbol) &&
                boardState[4].equals(playerSaymbol) &&
                boardState[6].equals(playerSaymbol)) {
            return true;
        }
        return false;
    }
}