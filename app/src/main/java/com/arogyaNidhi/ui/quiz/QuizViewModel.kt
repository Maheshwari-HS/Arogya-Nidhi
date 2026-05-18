package com.arogyaNidhi.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arogyaNidhi.data.SchemeRepository
import com.arogyaNidhi.model.*

class QuizViewModel : ViewModel() {

    private val _currentStep = MutableLiveData(0)
    val currentStep: LiveData<Int> = _currentStep

    private val _profile = MutableLiveData(FamilyProfile())
    val profile: LiveData<FamilyProfile> = _profile

    private val _eligibleSchemes = MutableLiveData<List<HealthScheme>>()
    val eligibleSchemes: LiveData<List<HealthScheme>> = _eligibleSchemes

    val totalSteps = 5

    val quizSteps = listOf(
        QuizStep(
            questionId = "income",
            question = "What is your family's annual income?",
            subtitle = "Include all sources: farming, wages, business, etc.",
            inputType = InputType.SINGLE_CHOICE,
            options = listOf(
                "Below ₹50,000",
                "₹50,000 – ₹1,50,000",
                "₹1,50,000 – ₹3,00,000",
                "₹3,00,000 – ₹5,00,000",
                "Above ₹5,00,000"
            )
        ),
        QuizStep(
            questionId = "occupation",
            question = "What is the primary occupation of your family?",
            subtitle = "Select the one that best describes your main income source",
            inputType = InputType.SINGLE_CHOICE,
            options = listOf(
                "Farmer / Agriculture",
                "Daily Wage / Labourer",
                "Construction Worker",
                "Domestic Worker",
                "Street Vendor / Self-employed",
                "Government / Private Job",
                "Other"
            )
        ),
        QuizStep(
            questionId = "bpl",
            question = "Does your family have a BPL (Below Poverty Line) card or Ration Card?",
            subtitle = "This is issued by the state government",
            inputType = InputType.YES_NO
        ),
        QuizStep(
            questionId = "special",
            question = "Does your family include any of the following?",
            subtitle = "Select all that apply to your family members",
            inputType = InputType.SINGLE_CHOICE,
            options = listOf(
                "Senior Citizen (60+ years)",
                "Pregnant Woman",
                "Person with Disability",
                "None of the above"
            )
        ),
        QuizStep(
            questionId = "family_size",
            question = "How many members are in your family?",
            subtitle = "Count all people living in your household",
            inputType = InputType.SINGLE_CHOICE,
            options = listOf("1–2 members", "3–4 members", "5–6 members", "7 or more members")
        )
    )

    // Temp state holders
    private var selectedIncome = 0
    private var selectedOccupation = ""
    private var isBPL = false
    private var isDisabled = false
    private var hasSeniorCitizen = false
    private var hasPregnantWoman = false
    private var familySize = 1

    fun answerStep(stepIndex: Int, answer: String) {
        when (stepIndex) {
            0 -> selectedIncome = when (answer) {
                "Below ₹50,000" -> 40000
                "₹50,000 – ₹1,50,000" -> 100000
                "₹1,50,000 – ₹3,00,000" -> 225000
                "₹3,00,000 – ₹5,00,000" -> 400000
                else -> 600000
            }
            1 -> selectedOccupation = when (answer) {
                "Farmer / Agriculture" -> "farmer"
                "Daily Wage / Labourer" -> "labourer"
                "Construction Worker" -> "construction"
                "Domestic Worker" -> "domestic worker"
                "Street Vendor / Self-employed" -> "street vendor"
                else -> "employed"
            }
            2 -> isBPL = answer == "Yes"
            3 -> {
                isDisabled = answer == "Person with Disability"
                hasSeniorCitizen = answer == "Senior Citizen (60+ years)"
                hasPregnantWoman = answer == "Pregnant Woman"
            }
            4 -> familySize = when (answer) {
                "1–2 members" -> 2
                "3–4 members" -> 4
                "5–6 members" -> 6
                else -> 8
            }
        }
    }

    fun goNext() {
        val next = (_currentStep.value ?: 0) + 1
        _currentStep.value = next
        if (next >= totalSteps) computeResults()
    }

    fun goPrevious() {
        val prev = (_currentStep.value ?: 0) - 1
        if (prev >= 0) _currentStep.value = prev
    }

    fun isLastStep() = (_currentStep.value ?: 0) == totalSteps - 1

    private fun computeResults() {
        val schemes = SchemeRepository.getEligibleSchemes(
            annualIncome = selectedIncome,
            isBPL = isBPL,
            occupation = selectedOccupation,
            isDisabled = isDisabled,
            hasSeniorCitizen = hasSeniorCitizen,
            hasPregnantWoman = hasPregnantWoman
        )
        _eligibleSchemes.value = schemes
        _profile.value = FamilyProfile(
            annualIncome = selectedIncome,
            occupation = selectedOccupation,
            isBPL = isBPL,
            isDisabled = isDisabled,
            hasSeniorCitizen = hasSeniorCitizen,
            hasPregnantWoman = hasPregnantWoman,
            familySize = familySize
        )
    }

    fun reset() {
        _currentStep.value = 0
        _eligibleSchemes.value = emptyList()
        _profile.value = FamilyProfile()
        selectedIncome = 0; selectedOccupation = ""; isBPL = false
        isDisabled = false; hasSeniorCitizen = false; hasPregnantWoman = false
    }
}
