package com.example.a2laba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Генерация случайного числа от 0 до 100
        Random random = new Random();
        secretNumber = random.nextInt(101);

        Button guessButton = findViewById(R.id.button_accept);
        Button restartButton = findViewById(R.id.button_restart);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNumber = findViewById(R.id.editText1);
                String guessString = editTextNumber.getText().toString();
                try {
                if (!guessString.isEmpty()) {
                    int guess = Integer.parseInt(guessString);
                    checkGuess(guess);
                } }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Введите число", Toast.LENGTH_SHORT).show();
                }
            }
        });
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                secretNumber = random.nextInt(101);
                Toast.makeText(MainActivity.this, "Игра рестартнута", Toast.LENGTH_SHORT).show();
                EditText editTextNumber = findViewById(R.id.editText1);
                String guessString = editTextNumber.getText().toString();
                try {
                    if (!guessString.isEmpty()) {
                        int guess = Integer.parseInt(guessString);
                        checkGuess(guess);
                    } }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Введите число", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkGuess(int guess) {
        TextView resultTextView = findViewById(R.id.textView1);
        if (guess < 0 || guess > 100) {
            Toast.makeText(MainActivity.this, "Введите число от 0 до 100", Toast.LENGTH_SHORT).show();
            return;
        }
        if (guess > secretNumber) {
            resultTextView.setText("Введенное число больше загаданного");
        } else if (guess < secretNumber) {
            resultTextView.setText("Введенное число меньше загаданного");
        } else {
            resultTextView.setText("Ура, победа!");

        }
    }
}