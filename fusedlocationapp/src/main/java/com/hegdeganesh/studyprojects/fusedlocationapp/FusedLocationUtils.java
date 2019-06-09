package com.hegdeganesh.studyprojects.fusedlocationapp;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.LocationSource;

/**
 * Created by User on 14-12-2016.
 */

public class FusedLocationUtils implements GoogleApiClient.ConnectionCallbacks
        ,GoogleApiClient.OnConnectionFailedListener,LocationListener,LocationSource {

    Context mContext;
    Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    String lat,lon;
    IFusedLocation ifused;

   // GoogleApiClient.OnConnectionFailedListener fListener;
    //GoogleApiClient.ConnectionCallbacks callbacks;

    public FusedLocationUtils(Context context,IFusedLocation ifused) {
        this.mContext = context;
        this.ifused = ifused;

      //  this.fListener = fListener;
      //  this.callbacks = callbacks;
    }

    public interface IFusedLocation{
        void updateLatLon(String lat,String lon);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(10000); // Update location every second

        try {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
        } catch (SecurityException e) {
           e.printStackTrace();
        }


        if (mLastLocation != null) {
            lat = String.valueOf(mLastLocation.getLatitude());
            lon = String.valueOf(mLastLocation.getLongitude());

        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        buildGoogleApiClient();
    }

    @Override
    public void onLocationChanged(Location location) {
        updateUI();
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    void updateUI() {
        Log.d("lat",lat);
        Log.d("lon",lon);

        ifused.updateLatLon(lat,lon);
    }

    @Override
    public void deactivate() {

    }

    synchronized void buildGoogleApiClient() {

       /* mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addConnectionCallbacks(callbacks)
                .addOnConnectionFailedListener(fListener)
                .addApi(LocationServices.API)
                .build();*/

        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    public void onConnect(){
        mGoogleApiClient.connect();
    }

    public void disconnect(){
        mGoogleApiClient.disconnect();
    }


}
