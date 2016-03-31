package com.example.alexandreroussiere.tempconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.graphics.Color;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private EditText text;
    private View view; //create object to manipulate background color
    ImageView iv; //create iv object to manipulate image view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        text = (EditText) findViewById(R.id.editText);

    }

    // this method is called when user clicks the button and is handled because we
    // assigned the name to the "OnClick property" of the button
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                RadioButton celsiusButton = (RadioButton)
                        findViewById(R.id.radioButton2);
                RadioButton fahrenheitButton = (RadioButton)
                        findViewById(R.id.radioButton);
                //If the user didn't put any text, we show an error message
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());

                //If the celsius button is checked it means we want to make a conversion into Fahrenheit
                if (celsiusButton.isChecked()) {
                    view = findViewById(R.id.mainLayout);
                    text.setText(String
                            .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);

                    //If the temperature is very warm, we change the color of the background and we add a picture
                    if(inputValue > 90){
                        //set hex color to skyblue
                        view.setBackgroundColor(Color.parseColor("#87ceff"));
                        iv=(ImageView) findViewById(R.id.imageView);
                        //clear any prior image
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setImageResource(R.drawable.warm);  //set the warm picture
                        iv.setVisibility(View.VISIBLE); //Show the picture

                    //If the temperature is very cold we also change the color of the background and we add a picture
                    }else if(inputValue < 0){
                        //set background color to red
                        view.setBackgroundColor(Color.parseColor("#F00B41"));
                        iv=(ImageView) findViewById(R.id.imageView);
                        //clear any prior image
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setImageResource(R.drawable.cold);  //set the cold picture
                        iv.setVisibility(View.VISIBLE); //show the picture

                    }
                    //Otherwise we just change the color of the background
                    else {
                        view.setBackgroundColor(Color.YELLOW);
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setVisibility(View.INVISIBLE); //We don't need any picture do display
                    }

                //Otherwise it means that this is the fahrenheit button which is checked
                } else {
                    view = findViewById(R.id.mainLayout);
                    iv=(ImageView) findViewById(R.id.imageView);
                    text.setText(String
                            .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);

                    //If the temperature is very warm, we change the color of the background and we add a picture
                    if (inputValue>32)
                    {
                        //set hex color to skyblue
                        view.setBackgroundColor(Color.parseColor("#87ceff"));
                        //clear any prior image
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setImageResource(R.drawable.warm);  //set the warm picture
                        iv.setVisibility(View.VISIBLE); //Show the picture

                    }
                    //If the temperature is very cold we also change the color of the background and we add a picture
                    else if (inputValue<-17){
                        //set background color to red
                        view.setBackgroundColor(Color.parseColor("#F00B41"));
                        //clear any prior image
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setImageResource(R.drawable.cold);  //set the cold picture
                        iv.setVisibility(View.VISIBLE); //Show the picture


                    }
                    //Otherwise we just change the color of the background
                    else {
                        view.setBackgroundColor(Color.YELLOW);
                        ((ImageView) iv.findViewById(R.id.imageView)).setImageResource(0);
                        iv.setVisibility(View.INVISIBLE);//We don't need any picture do display
                    }
                }
                break;
        }
    }

}
