package com.ppm.imagine;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguratorWidgetWeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurator_widget_weather);

        final EditText editText = (EditText) findViewById(R.id.city);
        ImageButton imageButton = (ImageButton)findViewById(R.id.cityButton);
        final ImageView imageView = (ImageView) findViewById(R.id.iconWeather);
        final TextView temp = (TextView)findViewById(R.id.temp);
        final TextView cityView = (TextView)findViewById(R.id.cityView);
        final Drawable dr = new BitmapDrawable(User.mirrors.get(Configurator.espejoActual).getConfigurator().getWidgetWeather().getPathImagen());



        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                User.mirrors.get(Configurator.espejoActual).getConfigurator().getWidgetWeather().setCity(editText.getText().toString());
                User.mirrors.get(Configurator.espejoActual).getConfigurator().getWidgetWeather().getWeather(editText.getText().toString());
                imageView.setImageDrawable(dr);
                temp.setText(User.mirrors.get(Configurator.espejoActual).getConfigurator().getWidgetWeather().getTemp().toString());
                cityView.setText(User.mirrors.get(Configurator.espejoActual).getConfigurator().getWidgetWeather().getCity());




            }
        });

    }

}