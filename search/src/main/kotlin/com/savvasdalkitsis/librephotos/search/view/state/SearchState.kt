package com.savvasdalkitsis.librephotos.search.view.state

import com.savvasdalkitsis.librephotos.feed.view.state.FeedDisplay
import com.savvasdalkitsis.librephotos.userbadge.api.view.state.UserInformationState

data class SearchState(
    val query: String = "",
    val showClearButton: Boolean = false,
    val searchResults: SearchResults = SearchResults.Idle,
    val userInformationState: UserInformationState = UserInformationState(),
    val showAccountOverview: Boolean = false,
    val feedDisplay: FeedDisplay = FeedDisplay.default,
)