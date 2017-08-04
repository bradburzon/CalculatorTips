package com.bradburzon.tipcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText price;
    private TextView tip, total;
    private Button ten, fifteen, twenty;
    private DecimalFormat df;
    private double priceFormatted;
    private double tipFormatted;
    private EditText customTip;

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
        customTip = (EditText) findViewById(R.id.customTip);

        //setup
        price.setText("");
       fifteen.setBackgroundColor(Color.GREEN);

        TextWatcher inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double newPrice = 0;
                if (!editable.toString().isEmpty()) {
                    newPrice = Double.parseDouble(price.getText().toString());
                }
                priceFormatted = Double.parseDouble(df.format(newPrice));
                tipFormatted = Double.parseDouble(df.format(newPrice * .15));
                tip.setText("$" + priceFormatted * .15);
                total.setText("$" + (priceFormatted + tipFormatted));
            }
        };

        price.addTextChangedListener(inputTextWatcher);

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText("");
                tip.setText("");
               calculate(15);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(.10);
                ten.setBackgroundColor(Color.GREEN);
            }
        });

        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(.15);
                fifteen.setBackgroundColor(Color.GREEN);
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(.20);
                twenty.setBackgroundColor(Color.GREEN);
            }
        });
    }

    public void calculate(double tipPercentage) {
        try {
            //input might be text from the start

            double inputPrice = Double.parseDouble(price.getText().toString());
            priceFormatted = Double.parseDouble(df.format(inputPrice));
            tipFormatted = Double.parseDouble(df.format(inputPrice * tipPercentage));
           // price.setText("" + priceFormatted);
            tip.setText("$" + tipFormatted);
            String totalPriceFormatted = df.format(priceFormatted + tipFormatted);
            total.setText("$" + totalPriceFormatted);
        } catch (Exception e) {
            price.setText("");
            tip.setText("tip");
            total.setText("total");
        }

        twenty.setBackgroundColor(Color.WHITE);
        ten.setBackgroundColor(Color.WHITE);
        fifteen.setBackgroundColor(Color.WHITE);
    }
}
