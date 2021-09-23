package com.challenge.homefeeds.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.homefeeds.model.FeedCardItem
import com.challenge.homefeeds.model.HomeFeedsPage
import com.challenge.homefeeds.model.HomeFeedsRepository
import com.challenge.homefeeds.model.Page
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFeedsViewModel : ViewModel() {

    private val repository: HomeFeedsRepository = HomeFeedsRepository()
    private val homeFeedsData = MutableLiveData<HomeFeedsPage>()
    private val errorMessageData = MutableLiveData<String>()

    val homeFeeds: LiveData<HomeFeedsPage>
    get() = homeFeedsData

    val errorMessage: LiveData<String>
        get() = errorMessageData

    init {
        getHomeFeeds()
    }

    private fun getHomeFeeds() {
        
        repository.getHomeFeeds().enqueue(object: Callback<HomeFeedsPage> {
            override fun onResponse(call: Call<HomeFeedsPage>, response: Response<HomeFeedsPage>) {
                homeFeedsData.value = response.body()
                UserList(page = response.body()!!.page)

            }

            override fun onFailure(call: Call<HomeFeedsPage>, t: Throwable) {
                errorMessageData.value = t.toString()
            }

        })
    }

    @Composable
    private fun UserList(page: Page){
//        homeFeedsViewModel.homeFeeds.
        LazyColumn {
            items(page.cards) { item ->
                UserRow(cardItem = item, onCardItemClick = {
//                    showMessage(context,"You clicked ${user.name}")
                })
            }
        }
    }

    @Composable
    private fun UserRow(cardItem: FeedCardItem, onCardItemClick: (FeedCardItem) -> Unit) {
        Row(modifier = Modifier
            .clickable(onClick = { onCardItemClick(cardItem) })
            .fillMaxWidth()
            .padding(8.dp)) {

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