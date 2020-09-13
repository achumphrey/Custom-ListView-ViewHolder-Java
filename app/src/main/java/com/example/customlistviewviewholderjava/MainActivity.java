package com.example.customlistviewviewholderjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Array of App Titles
    String[] OurApps = {
            "Master Android App",
            "Master Android App Pro",
            "Master Flutter App",
            "Subcribe to our channel",
            "Rate our app 5 stars"
    };

    // Array of Images
    int[] Images = {
            R.drawable.facebook,
            R.drawable.googleplus,
            R.drawable.instagram,
            R.drawable.youtube,
            R.drawable.facebook
    };

    // Array of Descriptions
    String[] Descriptions = {
            "Over 900,000 Users with 4.7 Rating",
            "Support us by Buying this App with $0.99",
            "Learn Flutter from Zero with this APP(4.0 Rating)",
            "Learn Kotlin from Zero to Hero",
            "Rate Master Android App 5 Star on Playstore",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView customList = findViewById(R.id.customListy);

        // Create instance of the CustomAdapter
        CustomAdapter customAdapter =
                new CustomAdapter(
                        this,
                        OurApps,
                        Images,
                        Descriptions);

        customList.setAdapter(customAdapter);
    }
}
