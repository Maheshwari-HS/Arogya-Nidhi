package com.arogyaNidhi.ui.hospital

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.arogyaNidhi.databinding.ItemHospitalBinding
import com.arogyaNidhi.model.Hospital
import com.arogyaNidhi.model.HospitalType

class HospitalAdapter(
    private var hospitals: List<Hospital>
) : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {

    inner class HospitalViewHolder(val binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = ItemHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        val h = hospitals[position]
        with(holder.binding) {
            tvHospitalName.text = h.name
            tvDistrict.text = "📍 ${h.district}"
            tvAddress.text = h.address
            tvPhone.text = "📞 ${h.phone}"
            tvSpecialties.text = h.specialties.take(3).joinToString(" • ")
            tvHospitalType.text = if (h.type == HospitalType.GOVERNMENT) "🏛 Government" else "🏥 Private (Empanelled)"
            tvSchemesCount.text = "${h.schemes.size} schemes accepted"
        }
    }

    override fun getItemCount() = hospitals.size

    fun updateList(newList: List<Hospital>) {
        hospitals = newList
        notifyDataSetChanged()
    }
}
