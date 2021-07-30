package com.example.visual_air;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class loco extends AppCompatActivity implements LocationListener {
    EditText land;
    private TextView textViewAddress;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private LocationManager locationManager;
    Button show,ba1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loco);
        textViewAddress = findViewById(R.id.textViewAddress);
        land = (EditText) findViewById(R.id.la1);
        show = (Button) findViewById(R.id.s1);
        ba1=(Button) findViewById(R.id.b1);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(loco.this,bpage.class);
                startActivity(in);
            }
        });
        ba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(loco.this,fpage.class);
                startActivity(in);
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (locationAccepted) {
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        if (ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
                        } else {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
                        }
                    }
                }
                break;
        }
    }

    private void getAddress(Location location) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            String address = addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            if (address != null) {
                textViewAddress.setText("Address : " + address);
            }
            Log.d("Log", "address : " + address);
            Log.d("Log", "city  : " + city);
            Log.d("Log", "state  : " + state);
            Log.d("Log", "country  : " + country);
            Log.d("Log", "postalCode  : " + postalCode);
            Log.d("Log", "knownName  : " + knownName);
        } catch (IOException e) {
            Toast.makeText(this, "Error : " + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.d("Log", "Error : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "Lat :" + location.getLatitude() + "\nLng : " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        getAddress(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


}