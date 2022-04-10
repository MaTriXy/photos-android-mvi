package com.savvasdalkitsis.librephotos.feed.viewmodel

import coil.annotation.ExperimentalCoilApi
import com.savvasdalkitsis.librephotos.account.usecase.AccountUseCase
import com.savvasdalkitsis.librephotos.albums.usecase.AlbumsUseCase
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageAction
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageAction.*
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageAction.ChangeDisplay
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageEffect
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageEffect.OpenPhotoDetails
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageEffect.ReloadApp
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageMutation
import com.savvasdalkitsis.librephotos.feed.mvflow.FeedPageMutation.*
import com.savvasdalkitsis.librephotos.feed.view.state.FeedPageState
import com.savvasdalkitsis.librephotos.userbadge.usecase.UserBadgeUseCase
import com.savvasdalkitsis.librephotos.viewmodel.Handler
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoilApi
@FlowPreview
class FeedPageHandler @Inject constructor(
    private val albumsUseCase: AlbumsUseCase,
    private val userBadgeUseCase: UserBadgeUseCase,
    private val accountUseCase: AccountUseCase,
) : Handler<FeedPageState, FeedPageEffect, FeedPageAction, FeedPageMutation> {

    override fun invoke(
        state: FeedPageState,
        action: FeedPageAction,
        effect: suspend (FeedPageEffect) -> Unit,
    ): Flow<FeedPageMutation> = when (action) {
        is LoadFeed -> merge(
            flowOf(Loading),
            albumsUseCase.getAlbums(refresh = false)
                .debounce(200)
                .map(::ShowAlbums),
            userBadgeUseCase.getUserBadgeState()
                .map(::UserBadgeUpdate),
        )
        UserBadgePressed -> flowOf(ShowAccountOverview)
        DismissAccountOverview -> flowOf(HideAccountOverview)
        LogOut -> flow {
            accountUseCase.logOut()
            effect(ReloadApp)
        }
        RefreshAlbums -> flow {
            emit(StartRefreshing)
            albumsUseCase.startRefreshAlbumsWork()
            delay(200)
            emit(StopRefreshing)
        }
        is SelectedPhoto -> flow {
            effect(OpenPhotoDetails(action.photo.id!!))
        }
        is ChangeDisplay -> flow {
            if (state.feedState.feedDisplay != action.display) {
                emit(FeedPageMutation.ChangeDisplay(action.display))
            }
        }
    }
}
