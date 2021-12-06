package com.example.mvvm_clean_arquitecture.ui.dialog.view

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.example.mvvm_clean_arquitecture.databinding.FragmentExampleDialogBinding
import com.example.mvvm_clean_arquitecture.ui.dialog.viewmodel.ExampleDialogViewModel

class ExampleDialogFragment : DialogFragment() {

    companion object {

        fun newInstance(): ExampleDialogFragment {
            return ExampleDialogFragment()
        }
    }

    interface DialogFragmentListener {

        fun onAgree()
        fun onCancel()
    }

    private lateinit var binding: FragmentExampleDialogBinding
    private val exampleDialogViewModel: ExampleDialogViewModel by viewModels()
    private var dialogFragmentListener: DialogFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExampleDialogBinding.inflate(layoutInflater)

        isCancelable = false

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFullScreen()
        setUpListeners()
    }

    fun show(fragmentManager: FragmentManager, dialogFragmentListener: DialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener
        show(fragmentManager, "dialog_fragment")
    }

    private fun setUpListeners() {
        binding.btnDialogfragmentCancel.setOnClickListener {
            dialogFragmentListener?.onCancel()
            dismiss()
        }

        binding.btnDialogfragmentAgree.setOnClickListener {
            dialogFragmentListener?.onAgree()
            dismiss()
        }
    }

    /**
     * Call this method (in onActivityCreated or later) to set
     * the width of the dialog to a percentage of the current
     * screen width.
     */
    private fun setWidthPercent(percentage: Int) {
        val percent = percentage.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * percent
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    /**
     * Call this method (in onActivityCreated or later)
     * to make the dialog near-full screen.
     */
    private fun setFullScreen() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}