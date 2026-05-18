# 🏥 Arogya Nidhi (आरोग्य निधि)
### Your Health Scheme Eligibility Advisor

An Android application that helps rural and low-income families in Karnataka 
discover which government health schemes they are eligible for — and exactly 
what documents they need to apply.

---

## 📌 Problem
Millions of eligible families in India never claim their government health 
benefits simply because they don't know they qualify. PM-JAY alone has 8 crore 
unenrolled eligible families. This app breaks that information barrier.

---

## ✨ Features
- ✅ 5-question eligibility quiz (no internet needed)
- ✅ Covers 8 Central and Karnataka State health schemes
- ✅ Interactive document checklist per scheme
- ✅ Hospital finder — search by district, filtered by your schemes
- ✅ Works fully offline — no login or registration required

---

## 🏛 Schemes Covered

| No | Scheme | Coverage | For |
|----|--------|----------|-----|
| 1 | PM-JAY | ₹5 Lakh/year | BPL families |
| 2 | Arogya Karnataka | ₹5 Lakh/year | Income below ₹5L |
| 3 | JSSK | Free | Pregnant women |
| 4 | RSBY | ₹30,000/year | Unorganised workers |
| 5 | NPHCE | Free OPD | Senior citizens |
| 6 | Niramaya | ₹1 Lakh/year | Persons with disabilities |
| 7 | PMMVY | ₹5,000 cash | First-time mothers |
| 8 | CM Relief Fund | Up to ₹2 Lakh | Critical illness |

---

## 🛠 Tech Stack
- **Language:** Kotlin
- **Architecture:** MVVM
- **Navigation:** Jetpack Navigation Component
- **UI:** Material Design 3, ViewBinding
- **State:** LiveData + ViewModel
- **Min SDK:** API 23 (Android 6.0+)

---

## 🚀 How to Run
1. Clone the repo
2. Open in Android Studio
3. Wait for Gradle sync
4. Run on emulator or physical device (API 23+)

---

## 📁 Project Structure

```
ArogyaNidhi/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/arogyaNidhi/
│           │   ├── MainActivity.kt
│           │   ├── model/
│           │   │   └── Models.kt              → FamilyProfile, HealthScheme, Hospital
│           │   ├── data/
│           │   │   ├── SchemeRepository.kt    → 8 schemes + decision tree logic
│           │   │   └── HospitalRepository.kt  → 15 hospitals + district search
│           │   └── ui/
│           │       ├── HomeFragment.kt        → Landing screen
│           │       ├── AllSchemesFragment.kt  → Browse all schemes
│           │       ├── quiz/
│           │       │   ├── QuizFragment.kt    → 5-step eligibility quiz
│           │       │   └── QuizViewModel.kt   → Shared state + LiveData
│           │       ├── result/
│           │       │   ├── ResultFragment.kt          → Eligible scheme cards
│           │       │   ├── SchemeDetailFragment.kt    → Document checklist
│           │       │   ├── SchemeResultAdapter.kt     → RecyclerView adapter
│           │       │   └── DocumentChecklistAdapter.kt
│           │       └── hospital/
│           │           ├── HospitalFragment.kt  → District search
│           │           └── HospitalAdapter.kt   → RecyclerView adapter
│           ├── res/
│           │   ├── layout/       → 9 XML screen layouts
│           │   ├── navigation/   → nav_graph.xml (6 screens)
│           │   ├── drawable/     → shapes and selectors
│           │   ├── anim/         → slide animations
│           │   └── values/       → colors, strings, themes
│           └── AndroidManifest.xml
├── build.gradle
└── settings.gradle
```
