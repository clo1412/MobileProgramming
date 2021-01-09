package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantLocation extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_location);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng jakarta = new LatLng(-6.179809, 106.823076);

        Marker m1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.191841, 106.701514))
                .anchor(0.5f, 0.5f)
                .title("Green Lake")
                .snippet("Snippet1"));

        Marker m2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.191158,106.657651))
                .anchor(0.5f, 0.5f)
                .title("Tangerang")
                .snippet("Snippet2"));

        Marker m3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.179809,106.823076))
                .anchor(0.5f, 0.5f)
                .title("Jakatra")
                .snippet("Snippet3"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
    }
}