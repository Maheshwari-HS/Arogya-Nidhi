package com.arogyaNidhi.ui.quiz

import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arogyaNidhi.R
import com.arogyaNidhi.databinding.FragmentQuizBinding
import com.arogyaNidhi.model.InputType

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuizViewModel by activityViewModels()
    private var selectedAnswer: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentStep.observe(viewLifecycleOwner) { step ->
            renderStep(step)
        }

        binding.btnNext.setOnClickListener {
            val answer = selectedAnswer
            if (answer == null) {
                binding.tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }
            binding.tvError.visibility = View.GONE
            val currentStep = viewModel.currentStep.value ?: 0
            viewModel.answerStep(currentStep, answer)

            if (viewModel.isLastStep()) {
                viewModel.goNext()
                findNavController().navigate(R.id.action_quiz_to_result)
            } else {
                viewModel.goNext()
                selectedAnswer = null
            }
        }

        binding.btnBack.setOnClickListener {
            if ((viewModel.currentStep.value ?: 0) == 0) {
                findNavController().popBackStack()
            } else {
                viewModel.goPrevious()
                selectedAnswer = null
            }
        }
    }

    private fun renderStep(stepIndex: Int) {
        if (stepIndex >= viewModel.quizSteps.size) return
        val step = viewModel.quizSteps[stepIndex]

        // Progress
        val progress = ((stepIndex + 1).toFloat() / viewModel.totalSteps * 100).toInt()
        binding.progressBar.progress = progress
        binding.tvStepCounter.text = "Step ${stepIndex + 1} of ${viewModel.totalSteps}"

        // Question
        binding.tvQuestion.text = step.question
        binding.tvSubtitle.text = step.subtitle

        // Clear options
        binding.radioGroup.removeAllViews()
        binding.radioGroup.visibility = View.GONE
        binding.layoutYesNo.visibility = View.GONE

        when (step.inputType) {
            InputType.SINGLE_CHOICE -> {
                binding.radioGroup.visibility = View.VISIBLE
                step.options.forEach { option ->
                    val rb = RadioButton(requireContext()).apply {
                        text = option
                        textSize = 16f
                        setPadding(24, 20, 24, 20)
                        setBackgroundResource(R.drawable.bg_option_selector)
                        setButtonDrawable(android.R.color.transparent)
                        layoutParams = ViewGroup.MarginLayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply { bottomMargin = 12 }
                        setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) selectedAnswer = option
                        }
                    }
                    binding.radioGroup.addView(rb)
                }
            }
            InputType.YES_NO -> {
                binding.layoutYesNo.visibility = View.VISIBLE
                binding.btnYes.setOnClickListener {
                    selectedAnswer = "Yes"
                    binding.btnYes.setBackgroundResource(R.drawable.bg_btn_selected)
                    binding.btnNo.setBackgroundResource(R.drawable.bg_btn_unselected)
                }
                binding.btnNo.setOnClickListener {
                    selectedAnswer = "No"
                    binding.btnNo.setBackgroundResource(R.drawable.bg_btn_selected)
                    binding.btnYes.setBackgroundResource(R.drawable.bg_btn_unselected)
                }
            }
            else -> {}
        }

        // Back button
        binding.btnBack.text = if (stepIndex == 0) "Cancel" else "← Back"
        binding.btnNext.text = if (stepIndex == viewModel.totalSteps - 1) "See My Results →" else "Next →"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
