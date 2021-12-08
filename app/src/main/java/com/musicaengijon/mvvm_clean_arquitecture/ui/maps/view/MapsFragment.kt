package com.musicaengijon.mvvm_clean_arquitecture.ui.maps.view

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.musicaengijon.mvvm_clean_arquitecture.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.musicaengijon.mvvm_clean_arquitecture.databinding.FragmentMapsBinding
import com.musicaengijon.mvvm_clean_arquitecture.model.City
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.viewmodel.MapsViewModel

class MapsFragment : Fragment() {

    private lateinit var mapsViewModel: MapsViewModel
    private lateinit var binding: FragmentMapsBinding
    private lateinit var latlngBoundsBuilder: LatLngBounds.Builder

    private val callback = OnMapReadyCallback { googleMap ->

        setMapConfig(googleMap)


        mapsViewModel.cities.observe(viewLifecycleOwner, {
            addCitiesMapMarkers(it, googleMap)
            centerZoomInMap(googleMap)
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            mapsViewModel = ViewModelProvider(it)[MapsViewModel::class.java]
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun setMapConfig(googleMap: GoogleMap) {
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isCompassEnabled = true

        googleMap.setOnMapClickListener {
            centerZoomInMap(googleMap)
        }

        setInfoWindowClickListener(googleMap)
    }

    private fun setInfoWindowClickListener(googleMap: GoogleMap) {
        googleMap.setOnInfoWindowClickListener { marker ->
            Toast.makeText(requireContext(), "${marker.title } tapped!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun centerZoomInMap(googleMap: GoogleMap) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBoundsBuilder.build(), 200))
    }

    private fun addCitiesMapMarkers(cities: List<City>, googleMap: GoogleMap) {
        latlngBoundsBuilder = LatLngBounds.builder()
        for (city in cities) {
            val markerLocation = LatLng(city.latitude.toDouble(), city.longitude.toDouble())
            latlngBoundsBuilder.include(markerLocation)
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .position(markerLocation)
                    .title(city.name)
                    .icon(BitmapDescriptorFactory.defaultMarker((342F)))
            )
        }
    }
}