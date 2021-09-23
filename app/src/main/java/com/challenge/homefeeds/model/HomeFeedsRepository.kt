package com.challenge.homefeeds.model

import com.challenge.homefeeds.model.remote.HomeFeedsService

class HomeFeedsRepository {

    private val homeFeedsService: HomeFeedsService = HomeFeedsService.create()

    fun getHomeFeeds() = homeFeedsService.getHomeFeeds()
}