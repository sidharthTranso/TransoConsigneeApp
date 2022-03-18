package com.example.consigneetransoapp

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Dialog
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.consigneetransoapp.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.remarks.setOnClickListener {
            RemarksCustomDialog().show(supportFragmentManager, "Remarks")
        }
        binding.uploadInMap.setOnClickListener {
//            val openDialog = Dialog(this)
//            openDialog.setContentView(R.layout.upload_image)
            UploadImageDialog().show(supportFragmentManager, "Upload Image")
            //val btn = UploadImageDialog.
        }
        binding.submit.setOnClickListener {
            SignatureDialog().show(supportFragmentManager, "Signature")
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(12.9784, 77.6408)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Transo"))
       // mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) )

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14F))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


}