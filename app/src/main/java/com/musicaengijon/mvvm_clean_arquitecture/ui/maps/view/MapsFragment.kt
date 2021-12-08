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
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.musicaengijon.mvvm_clean_arquitecture.databinding.FragmentMapsBinding
import com.musicaengijon.mvvm_clean_arquitecture.ui.maps.viewmodel.MapsViewModel

class MapsFragment : Fragment() {

    private lateinit var mapViewModel: MapsViewModel

    //    by navGraphViewModels(R.id.maps_navigation)
    private lateinit var binding: FragmentMapsBinding
    private val callback = OnMapReadyCallback { googleMap ->

        fetchData()
        mapViewModel.cities.observe(viewLifecycleOwner, {
           val list = it
        })

//        val sydney = LatLng(-34.0, 151.0)
//        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
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
            mapViewModel = ViewModelProvider(it)[MapsViewModel::class.java]
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun fetchData() {
        mapViewModel.fetchData()
    }
}