package com.challenge.homefeeds.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.homefeeds.databinding.HomeFeedsFragmentBinding
import com.challenge.homefeeds.model.FeedCardItem

class HomeFeedsAdapter: RecyclerView.Adapter<HomeFeedsAdapter.FeedHolder>() {

    private var cards = mutableListOf<FeedCardItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = HomeFeedsFragmentBinding.inflate(inflater, parent, false)
        return FeedHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        val card = cards[position]
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun setHomeFeedsList(cards: List<FeedCardItem>) {
        this.cards = cards.toMutableList()
        notifyDataSetChanged()
    }

    class FeedHolder(binding: HomeFeedsFragmentBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}