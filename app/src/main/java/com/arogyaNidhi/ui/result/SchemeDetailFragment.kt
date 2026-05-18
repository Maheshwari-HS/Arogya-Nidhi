package com.arogyaNidhi.ui.result

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arogyaNidhi.data.SchemeRepository
import com.arogyaNidhi.databinding.FragmentSchemeDetailBinding

class SchemeDetailFragment : Fragment() {

    private var _binding: FragmentSchemeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSchemeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Read argument manually — no SafeArgs plugin dependency
        val schemeId = arguments?.getString("schemeId") ?: ""
        val scheme = SchemeRepository.allSchemes.find { it.id == schemeId }
        if (scheme == null) { findNavController().popBackStack(); return }

        binding.tvSchemeName.text = scheme.name
        binding.tvSchemeDescription.text = scheme.description
        binding.tvCoverageAmount.text = "💰 ${scheme.coverageAmount}"
        binding.tvAuthority.text = "🏛 ${scheme.authority}"
        binding.tvEligibility.text = "✅ Eligibility: ${scheme.eligibilityCriteria}"

        // Benefits
        binding.tvBenefits.text = scheme.benefits.joinToString("\n") { "✅  $it" }

        // Documents checklist (interactive ticking)
        binding.rvDocuments.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDocuments.adapter = DocumentChecklistAdapter(scheme.documents)

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
