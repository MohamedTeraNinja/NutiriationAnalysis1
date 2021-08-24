package com.mohammedragab.nutiriationanalysis1.analysisdata.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohammedragab.nutiriationanalysis1.databinding.ItemHistoryBinding
import com.mohammedragab.nutiriationanalysis1.model.ModelAdapter


class HistoryNutritionAdapter(val context:Context):ListAdapter<ModelAdapter, HistoryNutritionAdapter.HistoryViewHolder>(
    diffUtileCompartort
) {
    private  var lastposition:Boolean = false


    class HistoryViewHolder private  constructor(val  binding:ItemHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tripPropertiesData: ModelAdapter){
            binding.model= tripPropertiesData
            binding.executePendingBindings()
        }

        init {

        }

        companion object{
            fun from(parent:ViewGroup): HistoryViewHolder {
                val layoutInflater= LayoutInflater.from(parent.context)
                val binding=ItemHistoryBinding.inflate(layoutInflater,parent,false)
                return HistoryViewHolder(
                    binding)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item =getItem(position)
        holder.bind(item)





    }

companion object{
    val diffUtileCompartort= object:DiffUtil.ItemCallback<ModelAdapter>(){
        override fun areItemsTheSame(
            oldItem: ModelAdapter,
            newItem: ModelAdapter
        ): Boolean {
            return  oldItem.calores==newItem.calores

        }

        override fun areContentsTheSame(
            oldItem: ModelAdapter,
            newItem: ModelAdapter
        ): Boolean {
            return  oldItem==newItem
        }


    }

}


}
