package com.arogyaNidhi.ui

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arogyaNidhi.R
import com.arogyaNidhi.data.SchemeRepository
import com.arogyaNidhi.databinding.FragmentAllSchemesBinding
import com.arogyaNidhi.ui.result.SchemeResultAdapter

class AllSchemesFragment : Fragment() {

    private var _binding: FragmentAllSchemesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAllSchemesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvAllSchemes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAllSchemes.adapter = SchemeResultAdapter(SchemeRepository.allSchemes) { scheme ->
            findNavController().navigate(
                R.id.action_all_schemes_to_scheme_detail,
                bundleOf("schemeId" to scheme.id)
            )
        }

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
