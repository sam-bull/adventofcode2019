package com.example.adventofcode2019.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.adventofcode2019.R
import kotlinx.android.synthetic.main.item_day_stars.view.*

class MainAdapter(private val myDataset: IntArray) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val dayView: LinearLayout) : RecyclerView.ViewHolder(dayView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val dayView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_stars, parent, false) as LinearLayout

        return MainViewHolder(dayView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val day = position + 1
        val emoji: String = if (day == 25) "\uD83C\uDF84" else ""
        holder.dayView.day_label.text = "Day $day $emoji"
        val stars = myDataset[position]
        holder.dayView.part_1_star.displayedChild = if (stars > 0) 1 else 0
        holder.dayView.part_2_star.displayedChild = if (stars > 1) 1 else 0
    }

    override fun getItemCount() = myDataset.size
}