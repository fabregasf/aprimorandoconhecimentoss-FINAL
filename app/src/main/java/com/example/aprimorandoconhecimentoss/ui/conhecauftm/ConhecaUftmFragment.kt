package com.example.aprimorandoconhecimentoss.ui.conhecauftm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aprimorandoconhecimentoss.databinding.FragmentConhecauftmBinding
import com.example.aprimorandoconhecimentoss.databinding.RegulamentoGradFragmentBinding

class ConhecaUftmFragment : Fragment() {

    private var _binding: FragmentConhecauftmBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConhecauftmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}