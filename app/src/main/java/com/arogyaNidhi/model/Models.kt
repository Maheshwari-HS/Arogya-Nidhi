package com.arogyaNidhi.model

data class FamilyProfile(
    val annualIncome: Int = 0,
    val occupation: String = "",
    val isBPL: Boolean = false,
    val isDisabled: Boolean = false,
    val hasSeniorCitizen: Boolean = false,
    val hasPregnantWoman: Boolean = false,
    val familySize: Int = 1,
    val state: String = "Karnataka"
)

data class HealthScheme(
    val id: String,
    val name: String,
    val description: String,
    val coverageAmount: String,
    val eligibilityCriteria: String,
    val documents: List<String>,
    val benefits: List<String>,
    val authority: String,
    val schemeType: SchemeType
)

enum class SchemeType { CENTRAL, STATE, BOTH }

data class Hospital(
    val id: String,
    val name: String,
    val district: String,
    val address: String,
    val phone: String,
    val schemes: List<String>,
    val specialties: List<String>,
    val type: HospitalType
)

enum class HospitalType { GOVERNMENT, PRIVATE_EMPANELED }

data class QuizStep(
    val questionId: String,
    val question: String,
    val subtitle: String,
    val inputType: InputType,
    val options: List<String> = emptyList()
)

enum class InputType { NUMERIC, SINGLE_CHOICE, YES_NO }
