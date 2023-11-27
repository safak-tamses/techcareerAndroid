package com.example.lokasyonislemleri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.health.connect.datatypes.ExerciseRoute;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lokasyonislemleri.databinding.ActivityMainBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int izinKontrol = 0;
    private FusedLocationProviderClient flpc;
    private Task<Location> locationTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        flpc = LocationServices.getFusedLocationProviderClient(this);

        binding.buttonKonum.setOnClickListener(v -> {
            izinKontrol = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            if (izinKontrol == PackageManager.PERMISSION_GRANTED){
                locationTask = flpc.getLastLocation();
                konumBilgisiAl();

            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);

            }
        });

        setContentView(binding.getRoot());
    }
    public void konumBilgisiAl(){
        locationTask.addOnSuccessListener(location -> {
            if (location != null){
                binding.textViewKonum.setText(location.getLatitude() + " - " + location.getLongitude());
            }else {
                binding.textViewKonum.setText("hata olustu");
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100){
            izinKontrol = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "İzin onaylandı", Toast.LENGTH_SHORT).show();
                locationTask = flpc.getLastLocation();
                konumBilgisiAl();
            }else {
                Toast.makeText(getApplicationContext(), "İzin reddedildi", Toast.LENGTH_SHORT).show();
            }
        }
    }
}