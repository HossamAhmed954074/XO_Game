package com.example.xo_game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    EditText edtPlayer1Name;
    EditText edtPlayer2Name;
    Button btnStartGame;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edtPlayer1Name=findViewById(R.id.edd_player1name);
        edtPlayer2Name=findViewById(R.id.edd_player2name);
        btnStartGame=findViewById(R.id.botton_start);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnotherPage();
            }
        });


    }

    void goToAnotherPage(){
        Intent intent =new Intent(this,MainActivity.class);
        intent.putExtra("player1Name",edtPlayer1Name.getText().toString());
        intent.putExtra("player2Name",edtPlayer2Name.getText().toString());
        startActivity(intent);
    }
}
