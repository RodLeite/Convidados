package com.contacts.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.contacts.convidados.databinding.FragmentPresentBinding
import com.contacts.convidados.viewmodel.PresentViewModel

class PresentFragment : Fragment() {

    private var _binding: FragmentPresentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val presentViewModel =
            ViewModelProvider(this).get(PresentViewModel::class.java)

        _binding = FragmentPresentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPresent
        presentViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}