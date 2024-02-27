package com.example.ugaday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.Number);
        bControl = (Button)findViewById(R.id.button);

        guess = (int)(Math.random()*100);
        gameFinished = false;

        Integer.parseInt(etInput.getText().toString());
        tvInfo.setText(getResources().getString(R.string.ahead));
    }
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;



    public void onClick(){
        if (!gameFinished) {
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
                tvInfo.setText("Перелет!");
            if (inp < guess)
                tvInfo.setText("Недолет!");
            if (inp==guess)
                tvInfo.setText("В точку!");
            bControl.setText("Сыграть еще");
            gameFinished=true;
        }
        else
        {
            guess = (int) (Math.random()*100);
            bControl.setText("Ввести значение:");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished = false;
        }
        etInput.setText("");
    }
}