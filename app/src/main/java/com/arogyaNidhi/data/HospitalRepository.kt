package com.arogyaNidhi.data

import com.arogyaNidhi.model.Hospital
import com.arogyaNidhi.model.HospitalType

object HospitalRepository {

    val allHospitals: List<Hospital> = listOf(
        Hospital("h1", "Victoria Hospital", "Bengaluru", "Fort Road, Bengaluru – 560002", "080-26701150",
            listOf("pmjay", "abyss", "rsby", "jssk"), listOf("General Surgery", "Orthopaedics", "Gynaecology", "ENT"), HospitalType.GOVERNMENT),
        Hospital("h2", "Bowring & Lady Curzon Hospital", "Bengaluru", "Shivajinagar, Bengaluru – 560001", "080-25561902",
            listOf("pmjay", "abyss", "jssk", "pmmvy"), listOf("Medicine", "Paediatrics", "Obstetrics"), HospitalType.GOVERNMENT),
        Hospital("h3", "Manipal Hospital (Sarjapur)", "Bengaluru", "Sarjapur Road, Bengaluru – 560102", "080-25023456",
            listOf("pmjay", "abyss"), listOf("Cardiology", "Oncology", "Neurology", "Transplant"), HospitalType.PRIVATE_EMPANELED),
        Hospital("h4", "District Hospital Mysuru", "Mysuru", "Irwin Road, Mysuru – 570001", "0821-2420464",
            listOf("pmjay", "abyss", "rsby", "jssk", "pmmvy", "nphce"), listOf("General Medicine", "Surgery", "Gynaecology", "Paediatrics"), HospitalType.GOVERNMENT),
        Hospital("h5", "JSS Hospital", "Mysuru", "MG Road, Mysuru – 570004", "0821-2548422",
            listOf("pmjay", "abyss", "niramaya"), listOf("Cardiology", "Neurology", "Orthopaedics", "Oncology"), HospitalType.PRIVATE_EMPANELED),
        Hospital("h6", "District Hospital Mangaluru", "Dakshina Kannada", "Lady Goschen Hospital Road, Mangaluru – 575003", "0824-2220001",
            listOf("pmjay", "abyss", "jssk", "rsby"), listOf("Medicine", "Surgery", "Obstetrics", "ENT"), HospitalType.GOVERNMENT),
        Hospital("h7", "KMC Hospital Mangaluru", "Dakshina Kannada", "Ambedkar Circle, Mangaluru – 575001", "0824-2445858",
            listOf("pmjay", "abyss", "niramaya"), listOf("Cardiology", "Nephrology", "Oncology"), HospitalType.PRIVATE_EMPANELED),
        Hospital("h8", "District Hospital Hubli", "Dharwad", "Lamington Road, Hubli – 580029", "0836-2362801",
            listOf("pmjay", "abyss", "jssk", "nphce", "rsby"), listOf("General Medicine", "Orthopaedics", "Gynaecology"), HospitalType.GOVERNMENT),
        Hospital("h9", "KIMS Hospital Hubli", "Dharwad", "KIMS Campus, Hubli – 580022", "0836-2370012",
            listOf("pmjay", "abyss"), listOf("Cardiology", "Neurology", "Oncology", "Transplant"), HospitalType.PRIVATE_EMPANELED),
        Hospital("h10", "District Hospital Belagavi", "Belagavi", "BP Circle, Belagavi – 590001", "0831-2470911",
            listOf("pmjay", "abyss", "rsby", "jssk", "pmmvy"), listOf("Medicine", "Surgery", "Paediatrics"), HospitalType.GOVERNMENT),
        Hospital("h11", "District Hospital Shivamogga", "Shivamogga", "MG Road, Shivamogga – 577201", "08182-222222",
            listOf("pmjay", "abyss", "nphce", "jssk"), listOf("General Medicine", "Surgery", "Gynaecology"), HospitalType.GOVERNMENT),
        Hospital("h12", "District Hospital Kalaburagi", "Kalaburagi", "Super Market Road, Kalaburagi – 585101", "08472-222111",
            listOf("pmjay", "abyss", "rsby", "jssk", "nphce"), listOf("Medicine", "Surgery", "Orthopaedics"), HospitalType.GOVERNMENT),
        Hospital("h13", "District Hospital Tumakuru", "Tumakuru", "SIT Road, Tumakuru – 572101", "0816-2270566",
            listOf("pmjay", "abyss", "jssk", "pmmvy"), listOf("Medicine", "Surgery", "Gynaecology"), HospitalType.GOVERNMENT),
        Hospital("h14", "District Hospital Hassan", "Hassan", "Station Road, Hassan – 573201", "08172-267676",
            listOf("pmjay", "abyss", "rsby", "nphce"), listOf("General Medicine", "Surgery", "Paediatrics"), HospitalType.GOVERNMENT),
        Hospital("h15", "District Hospital Ballari", "Ballari", "Civil Lines, Ballari – 583101", "08392-275555",
            listOf("pmjay", "abyss", "rsby", "jssk"), listOf("Medicine", "Surgery", "Gynaecology", "ENT"), HospitalType.GOVERNMENT),
    )

    val allDistricts: List<String> = allHospitals.map { it.district }.distinct().sorted()

    fun searchHospitals(district: String, schemeIds: List<String> = emptyList()): List<Hospital> {
        return allHospitals.filter { hospital ->
            val districtMatch = district.isBlank() || hospital.district.lowercase().contains(district.lowercase())
            val schemeMatch = schemeIds.isEmpty() || schemeIds.any { it in hospital.schemes }
            districtMatch && schemeMatch
        }
    }
}
