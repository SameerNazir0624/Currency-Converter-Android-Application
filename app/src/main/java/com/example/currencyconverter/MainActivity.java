package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText enterAmount;
    Button btnConvert;
    TextView ConvertedAmount;

  Countryitem countryitem;
  String clickedCountryName;


    Countryitem countryitemTo;
    String clickedCountryNameTo;


    //////////////////////////////////////////

    private ArrayList<Countryitem> countryList;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniListCountry();

        btnConvert = findViewById(R.id.converter_btn);
        enterAmount = findViewById(R.id.amount_edit_text);
        ConvertedAmount = findViewById(R.id.converted_amount);


        Spinner spinnerCountries = findViewById(R.id.spinner_countries);
        Spinner spinnerCountriesTo = findViewById(R.id.spinner_countries_to);


        mAdapter = new CountryAdapter(this,countryList);
        spinnerCountries.setAdapter(mAdapter);
        spinnerCountriesTo.setAdapter(mAdapter);


spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        countryitem = (Countryitem) adapterView.getItemAtPosition(i);
        clickedCountryName = countryitem.getCountryName();
        Toast.makeText(MainActivity.this, clickedCountryName + "Selected", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                countryitemTo = (Countryitem) adapterView.getItemAtPosition(i);
                clickedCountryNameTo = countryitemTo.getCountryName();
                Toast.makeText(MainActivity.this, clickedCountryNameTo + "Selected", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double TotalConvertedAmount;
                Double amount = Double.parseDouble(enterAmount.getText().toString());

                if(clickedCountryName.equals("USA") && clickedCountryName.equals("pakistan")){
                    TotalConvertedAmount = amount*170.15;
                    String tot = String.format("%.2f",TotalConvertedAmount);
                    ConvertedAmount.setText("" + tot);
                }


            }
        });

    }

    private void iniListCountry() {

        countryList = new ArrayList<>();
        countryList.add(new Countryitem("pakistan",R.drawable.pakistan));
        countryList.add(new Countryitem("India",R.drawable.india));
        countryList.add(new Countryitem("China",R.drawable.china));
        countryList.add(new Countryitem("USA", R.drawable.unitedstates));
        countryList.add(new Countryitem("Vietnam", R.drawable.vietnam));
    }
}