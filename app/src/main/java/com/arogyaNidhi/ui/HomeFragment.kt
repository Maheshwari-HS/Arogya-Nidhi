package com.arogyaNidhi.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arogyaNidhi.R
import com.arogyaNidhi.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartQuiz.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_quiz)
        }

        binding.btnFindHospital.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_hospital)
        }

        binding.btnAllSchemes.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_schemes)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
