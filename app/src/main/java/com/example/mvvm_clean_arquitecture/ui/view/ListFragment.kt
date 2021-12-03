package com.example.mvvm_clean_arquitecture.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_arquitecture.R
import com.example.mvvm_clean_arquitecture.databinding.FragmentListBinding
import com.example.mvvm_clean_arquitecture.ui.MainActivity
import com.example.mvvm_clean_arquitecture.ui.view.adapter.CustomAdapter
import com.example.mvvm_clean_arquitecture.ui.viewmodel.ListViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val listViewModel: ListViewModel by viewModels()
    private val adapter: CustomAdapter = CustomAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.list_fragment_title)

        fetchData()

        listViewModel.loading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })

        listViewModel.items.observe(viewLifecycleOwner, Observer {
            adapter.RecyclerAdapter(it, requireContext())
            recyclerView = binding.rvOfficesListFragment
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
            recyclerView.adapter = adapter
        })
    }

    private fun fetchData() {
        listViewModel.fetchItems()
    }
}