package com.savvasdalkitsis.librephotos.home.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.savvasdalkitsis.librephotos.feed.view.state.FeedDisplay
import com.savvasdalkitsis.librephotos.home.navigation.HomeNavigationBar
import com.savvasdalkitsis.librephotos.home.navigation.NavigationStyle.BOTTOM_BAR
import com.savvasdalkitsis.librephotos.home.navigation.NavigationStyle.NAVIGATION_RAIL
import com.savvasdalkitsis.librephotos.home.navigation.homeNavigationStyle
import com.savvasdalkitsis.librephotos.ui.view.CommonScaffold
import com.savvasdalkitsis.librephotos.userbadge.api.view.UserBadge
import com.savvasdalkitsis.librephotos.userbadge.api.view.state.UserInformationState

@Composable
fun HomeScaffold(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = { Text("LibrePhotos") },
    navController: NavHostController,
    userInformationState: UserInformationState? = null,
    feedDisplay: FeedDisplay = FeedDisplay.default,
    feedNavigationName: String,
    searchNavigationName: String,
    selectionMode: Boolean = false,
    userBadgePressed: () -> Unit = {},
    actionBarContent: @Composable RowScope.() -> Unit = {},
    onReselected: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    val selectedBackground by animateColorAsState(
        when {
            selectionMode -> MaterialTheme.colors.primary
            else -> MaterialTheme.colors.background
        }.copy(alpha = 0.8f),
        animationSpec = tween(
            durationMillis = 200,
            delayMillis = 100,
            easing = LinearEasing
        ))
    CommonScaffold(
        modifier = modifier,
        title = title,
        toolbarColor = selectedBackground,
        bottomBarContent = {
            if (homeNavigationStyle() == BOTTOM_BAR) {
                HomeNavigationBar(
                    navController = navController,
                    feedDisplay = feedDisplay,
                    onReselected = onReselected,
                    feedNavigationName = feedNavigationName,
                    searchNavigationName = searchNavigationName,
                )
            }
        },
        actionBarContent = {
            actionBarContent()
            userInformationState?.let {
                UserBadge(
                    state = it,
                    userBadgePressed = userBadgePressed
                )
            }
        }
    ) { contentPadding ->
        when (homeNavigationStyle()) {
            BOTTOM_BAR -> content(contentPadding)
            NAVIGATION_RAIL -> Row {
                HomeNavigationBar(
                    contentPadding = contentPadding,
                    feedDisplay = feedDisplay,
                    navController = navController,
                    feedNavigationName = feedNavigationName,
                    searchNavigationName = searchNavigationName,
                )
                content(contentPadding)
            }
        }
    }
}