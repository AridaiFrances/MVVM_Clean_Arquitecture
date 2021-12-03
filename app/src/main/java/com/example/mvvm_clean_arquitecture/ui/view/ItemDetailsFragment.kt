package com.example.mvvm_clean_arquitecture.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_clean_arquitecture.R
import com.example.mvvm_clean_arquitecture.ui.viewmodel.ItemDetailsViewModel

class ItemDetailsFragment : Fragment() {

    companion object {

        fun newInstance() = ItemDetailsFragment()
    }

    private lateinit var viewModel: ItemDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }
}