package org.d3if2085.perhitungan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if2085.perhitungan.database.entity.Perhitungan
import org.d3if2085.perhitungan.databinding.ItemHistoryBinding
import org.d3if2085.perhitungan.viemodel.PerhitunganViewModel

class HistoryAdapter(val viewModel: PerhitunganViewModel): ListAdapter<Perhitungan,HistoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
    private val DIFF_CALLBACK=
        object :DiffUtil.ItemCallback<Perhitungan>(){
            override fun areItemsTheSame(oldItem: Perhitungan, newItem: Perhitungan): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Perhitungan, newItem: Perhitungan): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(val binding: ItemHistoryBinding, val viewModel: PerhitunganViewModel):RecyclerView.ViewHolder(binding.root) {
        fun bind(perhitungan: Perhitungan) = with(binding){
            with(binding){
                hasilTextView.text = perhitungan.hasil.toString()

                btnRemove.setOnClickListener {
                    viewModel.deleteHistory(perhitungan)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater,parent,false)
        return ViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}