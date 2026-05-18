package com.arogyaNidhi.ui.result

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.arogyaNidhi.databinding.ItemDocumentBinding

class DocumentChecklistAdapter(
    private val documents: List<String>
) : RecyclerView.Adapter<DocumentChecklistAdapter.DocViewHolder>() {

    private val checkedState = BooleanArray(documents.size) { false }

    inner class DocViewHolder(val binding: ItemDocumentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocViewHolder {
        val binding = ItemDocumentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DocViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocViewHolder, position: Int) {
        with(holder.binding) {
            checkBox.text = documents[position]
            checkBox.isChecked = checkedState[position]
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                checkedState[position] = isChecked
            }
        }
    }

    override fun getItemCount() = documents.size
}
