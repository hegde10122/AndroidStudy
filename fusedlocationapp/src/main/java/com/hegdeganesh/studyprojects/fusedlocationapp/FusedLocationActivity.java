package com.hegdeganesh.studyprojects.fusedlocationapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class FusedLocationActivity extends AppCompatActivity implements FusedLocationUtils.IFusedLocation{

    TextView txtLat,txtLon;
    FusedLocationUtils fusedLocationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fused_location);

        txtLat = (TextView)findViewById(R.id.txtLatitude);
        txtLon = (TextView)findViewById(R.id.txtLongitude);

        fusedLocationUtils = new FusedLocationUtils(FusedLocationActivity.this,FusedLocationActivity.this);
        fusedLocationUtils.buildGoogleApiClient();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fusedLocationUtils.disconnect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        fusedLocationUtils.disconnect();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fusedLocationUtils.onConnect();
    }

    @Override
    public void updateLatLon(String lat, String lon) {
        txtLat.setText(lat);
        txtLon.setText(lon);
    }
}
