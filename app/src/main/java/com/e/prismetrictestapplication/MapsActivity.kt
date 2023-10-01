package com.e.prismetrictestapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.e.prismetrictestapplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var binding: ActivityMapsBinding? = null
    private var lat: Double? = null
    private var lng: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        val bundle = intent.extras
        if (bundle!!.getString("getlat") != null) {
            lat = java.lang.Double.valueOf(bundle.getString("getlat"))
            lng = java.lang.Double.valueOf(bundle.getString("getlng"))
            Log.d("latlng", bundle.getString("getlat") + " " + bundle.getString("getlng"))
            //TODO here get the string stored in the string variable and do
            // setText() on userName
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
        val atul = LatLng(lat!!, lng!!)
        mMap!!.addMarker(MarkerOptions().position(atul).title("atul"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(atul))
    }
}