package com.bradburzon.tipcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText price;
    TextView tip, total;
    Button ten, fifteen, twenty;
    DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        df = new DecimalFormat("0.00");
        price = (EditText) findViewById(R.id.price);
        tip = (TextView) findViewById(R.id.tip);
        total = (TextView) findViewById(R.id.total);
        ten = (Button) findViewById(R.id.ten);
        fifteen = (Button) findViewById(R.id.fifteen);
        twenty = (Button) findViewById(R.id.twenty);

        //setup
        price.setText("Enterasd Price Check");
        ten.setBackgroundColor(Color.LTGRAY);
        fifteen.setBackgroundColor(Color.LTGRAY);
        twenty.setBackgroundColor(Color.LTGRAY);


        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText("");
                ten.setBackgroundColor(Color.LTGRAY);
                fifteen.setBackgroundColor(Color.LTGRAY);
                twenty.setBackgroundColor(Color.LTGRAY);
            }
        });



        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twenty.setBackgroundColor(Color.LTGRAY);
                ten.setBackgroundColor(Color.GREEN);
                fifteen.setBackgroundColor(Color.LTGRAY);
                if (price.getText().toString().isEmpty()) {
                    tip.setText("tip");
                    total.setText("total");
                } else {
                    price.setText(df.format(Double.parseDouble(price.getText().toString())));
                    double tipf = Double.parseDouble(price.getText().toString()) * .10;

                    tip.setText("$"+ df.format(tipf));
                    total.setText(df.format(Double.parseDouble(Double.parseDouble(price.getText().toString()) + tipf + "")));
                }
            }
        });

        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                ten.setBackgroundColor(Color.LTGRAY);
                twenty.setBackgroundColor(Color.LTGRAY);
                if (price.getText().toString().isEmpty()) {
                    tip.setText("tip");
                    total.setText("total");
                } else {
                    price.setText(df.format(Double.parseDouble(price.getText().toString())));
                    double tipf = Double.parseDouble(price.getText().toString()) * .15;

                    tip.setText("$" + df.format(tipf));
                    total.setText(df.format(Double.parseDouble(Double.parseDouble(price.getText().toString()) + tipf + "")));
                }
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.GREEN);
                ten.setBackgroundColor(Color.LTGRAY);
                fifteen.setBackgroundColor(Color.LTGRAY);
                if (price.getText().toString().isEmpty()) {
                    tip.setText("tip");
                    total.setText("total");
                } else {
                    price.setText(df.format(Double.parseDouble(price.getText().toString())));
                    double tipf = Double.parseDouble(price.getText().toString()) * .20;

                    tip.setText("$"+df.format(tipf));
                    total.setText(df.format(Double.parseDouble(Double.parseDouble(price.getText().toString()) + tipf + "")));
                }
            }
        });
    }

    public void setBackground(int color){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
