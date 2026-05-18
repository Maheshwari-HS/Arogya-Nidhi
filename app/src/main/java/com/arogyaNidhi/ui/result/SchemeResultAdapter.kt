package com.arogyaNidhi.ui.result

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.arogyaNidhi.databinding.ItemSchemeResultBinding
import com.arogyaNidhi.model.HealthScheme
import com.arogyaNidhi.model.SchemeType

class SchemeResultAdapter(
    private val schemes: List<HealthScheme>,
    private val onSchemeClick: (HealthScheme) -> Unit
) : RecyclerView.Adapter<SchemeResultAdapter.SchemeViewHolder>() {

    inner class SchemeViewHolder(val binding: ItemSchemeResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchemeViewHolder {
        val binding = ItemSchemeResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SchemeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchemeViewHolder, position: Int) {
        val scheme = schemes[position]
        with(holder.binding) {
            tvSchemeName.text = scheme.name
            tvSchemeDesc.text = scheme.description
            tvCoverage.text = "Coverage: ${scheme.coverageAmount}"
            tvAuthority.text = scheme.authority
            tvDocCount.text = "${scheme.documents.size} documents needed"

            val tagText = when (scheme.schemeType) {
                SchemeType.CENTRAL -> "Central Govt."
                SchemeType.STATE -> "State Govt."
                SchemeType.BOTH -> "Central + State"
            }
            tvSchemeTag.text = tagText

            root.setOnClickListener { onSchemeClick(scheme) }
        }
    }

    override fun getItemCount() = schemes.size
}
