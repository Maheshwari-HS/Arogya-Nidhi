package com.arogyaNidhi.ui.hospital

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arogyaNidhi.data.HospitalRepository
import com.arogyaNidhi.databinding.FragmentHospitalBinding
import com.arogyaNidhi.ui.quiz.QuizViewModel

class HospitalFragment : Fragment() {

    private var _binding: FragmentHospitalBinding? = null
    private val binding get() = _binding!!
    private val quizViewModel: QuizViewModel by activityViewModels()
    private lateinit var adapter: HospitalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // District autocomplete
        val districts = HospitalRepository.allDistricts
        val districtAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, districts)
        binding.autoCompleteDistrict.setAdapter(districtAdapter)

        // Initial load - show all or filtered by eligible schemes
        val eligibleSchemeIds = quizViewModel.eligibleSchemes.value?.map { it.id } ?: emptyList()
        adapter = HospitalAdapter(HospitalRepository.searchHospitals("", eligibleSchemeIds))
        binding.rvHospitals.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHospitals.adapter = adapter

        if (eligibleSchemeIds.isNotEmpty()) {
            binding.tvFilterInfo.text = "Showing hospitals that accept your eligible schemes"
            binding.tvFilterInfo.visibility = View.VISIBLE
        }

        // Search
        binding.autoCompleteDistrict.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val filtered = HospitalRepository.searchHospitals(s.toString(), eligibleSchemeIds)
                adapter.updateList(filtered)
                binding.tvNoResults.visibility = if (filtered.isEmpty()) View.VISIBLE else View.GONE
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.btnClearFilter.setOnClickListener {
            binding.autoCompleteDistrict.text.clear()
            adapter.updateList(HospitalRepository.searchHospitals("", emptyList()))
            binding.tvFilterInfo.visibility = View.GONE
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
