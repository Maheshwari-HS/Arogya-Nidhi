package com.arogyaNidhi.ui.result

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arogyaNidhi.R
import com.arogyaNidhi.databinding.FragmentResultBinding
import com.arogyaNidhi.ui.quiz.QuizViewModel

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val schemes = quizViewModel.eligibleSchemes.value ?: emptyList()

        if (schemes.isEmpty()) {
            binding.tvResultTitle.text = "No Schemes Found"
            binding.tvResultSubtitle.text =
                "Based on your details, you may not qualify for specific schemes right now. Please visit your nearest government hospital for assistance."
            binding.ivResultIcon.setImageResource(R.drawable.ic_info)
        } else {
            binding.tvResultTitle.text = "Great News! 🎉"
            binding.tvResultSubtitle.text =
                "You are eligible for ${schemes.size} government health scheme${if (schemes.size > 1) "s" else ""}. Tap any scheme to see the document checklist."
            binding.ivResultIcon.setImageResource(R.drawable.ic_check_circle)
        }

        binding.rvSchemes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSchemes.adapter = SchemeResultAdapter(schemes) { scheme ->
            // Navigate with manual bundle — no SafeArgs plugin needed
            findNavController().navigate(
                R.id.action_result_to_scheme_detail,
                bundleOf("schemeId" to scheme.id)
            )
        }

        binding.btnFindHospital.setOnClickListener {
            findNavController().navigate(R.id.action_result_to_hospital)
        }

        binding.btnStartOver.setOnClickListener {
            quizViewModel.reset()
            findNavController().navigate(R.id.action_result_to_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
