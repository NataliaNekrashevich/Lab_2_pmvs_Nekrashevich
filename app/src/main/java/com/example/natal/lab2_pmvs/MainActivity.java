package com.example.natal.lab2_pmvs;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    RelativeLayout view;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.tvInfo);
        etInput = (EditText)findViewById(R.id.eInput);
        bControl = (Button)findViewById(R.id.bControl);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void onClick(View v) {
        view =(RelativeLayout)findViewById(R.id.my_layout_id);
        if (!gameFinished){


            try {

                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp<0 || inp>100)
                    Toast.makeText(getBaseContext(), R.string.warning, Toast.LENGTH_LONG).show();
                if (inp > guess){
                    tvInfo.setText(getResources().getString(R.string.ahead));
                    view.setBackgroundColor(Color.parseColor("#FFFA8C97"));
                }
                if (inp < guess){
                    tvInfo.setText(getResources().getString(R.string.behind));
                    view.setBackgroundColor(Color.parseColor("#FFFA8C97"));
                }
                if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    view.setBackgroundColor(Color.parseColor("#FFB7FFB5"));
                    gameFinished = true;
                }

            }
            catch (Exception e) {
                Toast.makeText(getBaseContext(), "Неправильный ввод", Toast.LENGTH_LONG).show();
            }
        }

        else
        {
            guess = (int)(Math.random()*100);
            view.setBackgroundColor(Color.parseColor("#FFFFFFA9"));
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }



    public void exitClick(MenuItem item) {
        System.exit(0);
    }


}
