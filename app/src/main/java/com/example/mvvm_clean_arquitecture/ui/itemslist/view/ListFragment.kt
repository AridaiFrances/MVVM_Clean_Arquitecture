package com.example.mvvm_clean_arquitecture.ui.itemslist.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_arquitecture.R
import com.example.mvvm_clean_arquitecture.databinding.FragmentListBinding
import com.example.mvvm_clean_arquitecture.model.Item
import com.example.mvvm_clean_arquitecture.ui.dialog.view.ExampleDialogFragment
import com.example.mvvm_clean_arquitecture.ui.itemslist.MainActivity
import com.example.mvvm_clean_arquitecture.ui.itemslist.view.adapter.CustomAdapter
import com.example.mvvm_clean_arquitecture.ui.itemslist.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

//Dagger annotation to set ready the class
@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val listViewModel: ListViewModel by viewModels()
    private lateinit var adapter: CustomAdapter
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
            adapter = CustomAdapter(it) { item ->
                onListItemClick(item)
            }
            recyclerView = binding.rvOfficesListFragment
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
            recyclerView.adapter = adapter
        })
    }

    private fun fetchData() {
        listViewModel.fetchItems()
    }

    private fun onListItemClick(item: Item) {
//        followNavigationGraph()
        openFragmentDialog()
    }

    /**
     * Use this for continue the flow of navigation graph
     **/
    private fun followNavigationGraph() {
        findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
    }

    /**
     * Used to open a custom fragment dialog
     **/
    private fun openFragmentDialog() {
        val exampleDialogFragment = ExampleDialogFragment.newInstance()
        exampleDialogFragment.show(parentFragmentManager, object : ExampleDialogFragment.DialogFragmentListener {
            override fun onAgree() {
                Toast.makeText(requireContext(), "agree", Toast.LENGTH_SHORT).show()
            }

            override fun onCancel() {
                Toast.makeText(requireContext(), "cancel", Toast.LENGTH_SHORT).show()
            }
        })
    }
}