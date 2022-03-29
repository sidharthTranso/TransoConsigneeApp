package com.example.consigneetransoapp

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.consigneetransoapp.databinding.ActivityMapsBinding
import com.example.consigneetransoapp.model.ConsigneeDataRequest
import com.example.consigneetransoapp.model.ConsigneeDataResponse
import com.example.consigneetransoapp.repository.ConsigneeDataRepository
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.net.HttpURLConnection
import java.net.URL


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    //private val model: MapActivityViewModel by viewModels()
    companion object {
        private const val CAMERA_PERMISSION_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val action = intent.action
        val data: Uri? = intent.data
        Log.d("Intent", data.toString())
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // binding.progressBar.isVisible = true
        checkPermission(
            Manifest.permission.CAMERA,
            CAMERA_PERMISSION_CODE
        )
        if (data != null) {
            callApi(data)

        } else {
            binding.showError.isVisible = false
           // binding.progressBar.isVisible = true
            binding.showError.text = "Please click on a valid link"

//            binding.showError.isVisible = true
//            binding.progressBar.isVisible = false
//            binding.showError.text = "Please click on a valid link"
        }

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

    private fun callApi(data: Uri?) {
        val a = data.toString()
        val result = a.substringAfter("vendorLrNumber=").substringBefore(' ')

        val apiService = ConsigneeDataRepository()
        val userInfo = ConsigneeDataRequest(
            userUserName = result,
        )
        apiService.getConsigneeData(result) {
            if (it?.success == true) {
                Log.d("Api Hit Success", "True")
                setAllData(it)
            }
        }

        //    sendGet()


    }

    private fun setAllData(consigneeDataResponse: ConsigneeDataResponse) {
        binding.progressBar.isVisible = false
        binding.cardView.isVisible = true
        binding.sourceAddress.text = consigneeDataResponse.data!!.source_address
        binding.destinationAddress.text = consigneeDataResponse.data.destination_address

    }

    fun sendGet() {
        val url =
            URL("https://neintranso.nittsu.co.in:6044/trip/ShipmentTrackingByVendorLr?vendorLrNumber=55114294")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    it.lines().forEach { line ->
                        println(line)
                    }
                }
            }
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

    // Function to check and request permission.
    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
           // Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    // This function is called when the user accepts or decline the permission.
// Request Code is used to check which permission called this function.
// This request code is provided when the user is prompt for permission.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }


}