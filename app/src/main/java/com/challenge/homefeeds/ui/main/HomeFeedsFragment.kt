package com.challenge.homefeeds.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.challenge.homefeeds.R
import com.challenge.homefeeds.model.FeedCardItem
import com.challenge.homefeeds.model.HomeFeedsPage

class HomeFeedsFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFeedsFragment()
    }

    private lateinit var viewModel: HomeFeedsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lateinit var homeFeeds: HomeFeedsPage
        var errorMessage: String

        viewModel = ViewModelProvider(this).get(HomeFeedsViewModel::class.java)
        viewModel.homeFeeds.observe(viewLifecycleOwner, {
            homeFeeds = it
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, {
            errorMessage = it
        })

        return ComposeView(requireContext()).apply {
            setContent {
                UserList(homeFeeds.page.cards)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeFeedsViewModel::class.java)
        viewModel.homeFeeds.observe(viewLifecycleOwner, {
            it.toString()
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, {
            it.toString()
        })
    }

    @Composable
    private fun UserList(cardItems: List<FeedCardItem>){
        LazyColumn {
//            items(cardItems) {
//
//            }

            itemsIndexed(cardItems) { _, item ->
                UserRow(cardItem = item, onCardItemClick = {
//                    showMessage(context,"You clicked ${user.name}")
                })
            }
        }
    }

    @Composable
    private fun UserRow(cardItem: FeedCardItem, onCardItemClick: (FeedCardItem) -> Unit) {
        Row(modifier = Modifier.clickable(onClick = { onCardItemClick(cardItem) }).fillMaxWidth().padding(8.dp)) {

//            val imageModifier = Modifier.preferredSize(46.dp).clip(shape = CircleShape)
//            val image = imageResource(id = R.drawable.header)
//
//            Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)

            Column (modifier = Modifier.padding(start = 8.dp)){
                Text(text = cardItem.cardType, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6)

            }
        }
    }

}