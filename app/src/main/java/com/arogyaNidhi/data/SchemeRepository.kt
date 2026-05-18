package com.arogyaNidhi.data

import com.arogyaNidhi.model.HealthScheme
import com.arogyaNidhi.model.SchemeType

object SchemeRepository {

    val allSchemes: List<HealthScheme> = listOf(
        HealthScheme(
            id = "pmjay",
            name = "Ayushman Bharat – PM-JAY",
            description = "World's largest health insurance scheme providing free treatment up to ₹5 lakhs per family per year at empanelled hospitals.",
            coverageAmount = "₹5,00,000 per family/year",
            eligibilityCriteria = "BPL families or SECC-listed households",
            documents = listOf(
                "Aadhaar Card (all family members)",
                "Ration Card / BPL Card",
                "SECC Database printout (from CSC)",
                "Income Certificate (if applicable)",
                "Passport-size photographs",
                "Mobile number linked to Aadhaar"
            ),
            benefits = listOf(
                "Cashless treatment up to ₹5 lakh",
                "Covers pre & post hospitalization",
                "1,393 medical procedures covered",
                "No cap on family size",
                "Pre-existing diseases covered from Day 1"
            ),
            authority = "National Health Authority, Govt. of India",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "abyss",
            name = "Ayushman Bharat – Arogya Karnataka",
            description = "Karnataka state scheme extending health coverage to all residents not covered under PM-JAY, with ₹5 lakh coverage.",
            coverageAmount = "₹5,00,000 per family/year",
            eligibilityCriteria = "Karnataka residents with annual income below ₹5 lakh",
            documents = listOf(
                "Aadhaar Card",
                "Karnataka Domicile / Ration Card",
                "Income Certificate from Tahsildar",
                "Family Photograph",
                "Bank Account details"
            ),
            benefits = listOf(
                "Cashless treatment across Karnataka",
                "Covers 1,597 procedures",
                "Includes mental health treatment",
                "Ambulance services covered",
                "Follow-up consultations included"
            ),
            authority = "Karnataka Arogya Karnataka Authority",
            schemeType = SchemeType.STATE
        ),
        HealthScheme(
            id = "jssk",
            name = "Janani Shishu Suraksha Karyakram (JSSK)",
            description = "Entitles pregnant women and sick newborns to free maternity services at public health institutions.",
            coverageAmount = "Free services (no monetary cap)",
            eligibilityCriteria = "All pregnant women; no income restriction",
            documents = listOf(
                "Aadhaar Card",
                "Mother & Child Protection Card",
                "Any Government ID proof",
                "Referral slip from Primary Health Centre"
            ),
            benefits = listOf(
                "Free normal & Caesarean delivery",
                "Free medicines & consumables",
                "Free diagnostics & diet during stay",
                "Free blood transfusion",
                "Free transport to hospital & back home",
                "Free treatment for sick newborns up to 30 days"
            ),
            authority = "Ministry of Health & Family Welfare",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "rsby",
            name = "Rashtriya Swasthya Bima Yojana (RSBY)",
            description = "Smart card-based cashless health insurance for BPL and unorganized sector workers.",
            coverageAmount = "₹30,000 per family/year",
            eligibilityCriteria = "BPL families; unorganized sector workers",
            documents = listOf(
                "Aadhaar Card",
                "BPL Card / Below Poverty Line Certificate",
                "Employment proof (for unorganized sector)",
                "Family composition certificate",
                "Passport-size photos of all members"
            ),
            benefits = listOf(
                "Smart card issued at doorstep",
                "Cashless at empanelled hospitals",
                "Covers up to 5 family members",
                "Transportation allowance ₹100/visit",
                "Day care procedures covered"
            ),
            authority = "Ministry of Labour & Employment",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "nphce",
            name = "National Programme for Health Care of Elderly (NPHCE)",
            description = "Dedicated healthcare for senior citizens including free OPD, medicines, physiotherapy and home-based care.",
            coverageAmount = "Free services at government facilities",
            eligibilityCriteria = "Citizens aged 60 years and above",
            documents = listOf(
                "Aadhaar Card",
                "Age proof (Birth Certificate / Passport / School leaving certificate)",
                "Senior Citizen ID Card (if available)",
                "Photograph"
            ),
            benefits = listOf(
                "Dedicated OPD and wards",
                "Free medicines from essential drug list",
                "Free physiotherapy services",
                "Home-based care by health workers",
                "Geriatric day care centres",
                "Mental health support"
            ),
            authority = "Ministry of Health & Family Welfare",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "niramaya",
            name = "Niramaya Health Insurance (For Disabled)",
            description = "Health insurance scheme specifically for persons with disabilities, managed by National Trust.",
            coverageAmount = "₹1,00,000 per year",
            eligibilityCriteria = "Persons with Autism, Cerebral Palsy, Mental Retardation, or Multiple Disabilities",
            documents = listOf(
                "Disability Certificate from CMO / Civil Surgeon",
                "Aadhaar Card",
                "BPL Card (for subsidized premium)",
                "Guardian's ID proof",
                "Photograph",
                "Bank account details"
            ),
            benefits = listOf(
                "OPD treatment up to ₹7,500/year",
                "IPD treatment covered",
                "Alternative medicine (AYUSH) covered",
                "Corrective surgeries covered",
                "Transportation costs included",
                "Premium as low as ₹250/year for BPL"
            ),
            authority = "National Trust, Ministry of Social Justice",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "pmmvy",
            name = "Pradhan Mantri Matru Vandana Yojana (PMMVY)",
            description = "Maternity benefit programme providing cash incentives to pregnant and lactating mothers.",
            coverageAmount = "₹5,000 cash benefit in installments",
            eligibilityCriteria = "Pregnant women 19+ years; first live birth; not employed in regular Govt. jobs",
            documents = listOf(
                "Aadhaar Card",
                "Bank Passbook (Aadhaar-linked)",
                "MCP (Mother & Child Protection) Card",
                "Proof of pregnancy",
                "Mobile number"
            ),
            benefits = listOf(
                "₹1,000 on early ANC registration",
                "₹2,000 after 6 months of pregnancy & ANC check-up",
                "₹2,000 after child birth registration & first vaccine cycle",
                "Direct Benefit Transfer to bank account",
                "Conditional on institutional delivery"
            ),
            authority = "Ministry of Women & Child Development",
            schemeType = SchemeType.CENTRAL
        ),
        HealthScheme(
            id = "chief_minister_fund",
            name = "CM's Relief Fund – Medical Assistance (Karnataka)",
            description = "Emergency financial assistance from the Chief Minister's Relief Fund for serious illnesses not covered by other schemes.",
            coverageAmount = "Up to ₹2,00,000 (case-by-case)",
            eligibilityCriteria = "Karnataka residents with annual income below ₹1.5 lakh facing life-threatening illness",
            documents = listOf(
                "Application letter to the Chief Minister",
                "Income Certificate from Tahsildar",
                "Aadhaar Card",
                "Medical Certificate from treating doctor",
                "Hospital estimate letter",
                "BPL/Ration Card",
                "Bank account details"
            ),
            benefits = listOf(
                "One-time emergency financial assistance",
                "Covers cancer, kidney disease, heart surgery, etc.",
                "Direct fund transfer to hospital",
                "Fast-track processing for critical cases"
            ),
            authority = "Office of the Chief Minister, Karnataka",
            schemeType = SchemeType.STATE
        )
    )

    fun getEligibleSchemes(
        annualIncome: Int,
        isBPL: Boolean,
        occupation: String,
        isDisabled: Boolean,
        hasSeniorCitizen: Boolean,
        hasPregnantWoman: Boolean
    ): List<HealthScheme> {
        val eligible = mutableListOf<HealthScheme>()

        // PM-JAY: BPL or income < 1.5L
        if (isBPL || annualIncome <= 150000) {
            eligible.add(allSchemes.first { it.id == "pmjay" })
        }

        // Arogya Karnataka: Income < 5L
        if (annualIncome <= 500000) {
            eligible.add(allSchemes.first { it.id == "abyss" })
        }

        // JSSK: Any pregnant woman
        if (hasPregnantWoman) {
            eligible.add(allSchemes.first { it.id == "jssk" })
            eligible.add(allSchemes.first { it.id == "pmmvy" })
        }

        // RSBY: BPL or unorganized sector
        if (isBPL || occupation.lowercase() in listOf("farmer", "labourer", "daily wage", "construction", "domestic worker", "street vendor")) {
            if (!eligible.any { it.id == "rsby" })
                eligible.add(allSchemes.first { it.id == "rsby" })
        }

        // NPHCE: Senior citizen
        if (hasSeniorCitizen) {
            eligible.add(allSchemes.first { it.id == "nphce" })
        }

        // Niramaya: Disabled person
        if (isDisabled) {
            eligible.add(allSchemes.first { it.id == "niramaya" })
        }

        // CM Relief Fund: Very low income
        if (annualIncome <= 150000) {
            eligible.add(allSchemes.first { it.id == "chief_minister_fund" })
        }

        return eligible.distinctBy { it.id }
    }
}
