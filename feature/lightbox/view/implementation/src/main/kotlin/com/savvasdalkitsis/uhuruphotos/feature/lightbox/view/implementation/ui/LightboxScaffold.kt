/*
Copyright 2022 Savvas Dalkitsis

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.savvasdalkitsis.uhuruphotos.feature.lightbox.view.implementation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ScrollState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Compact
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.savvasdalkitsis.uhuruphotos.feature.auth.view.api.navigation.LocalServerUrl
import com.savvasdalkitsis.uhuruphotos.feature.lightbox.view.implementation.seam.actions.LightboxAction
import com.savvasdalkitsis.uhuruphotos.feature.lightbox.view.implementation.seam.actions.UpPressed
import com.savvasdalkitsis.uhuruphotos.feature.lightbox.view.implementation.ui.state.LightboxState
import com.savvasdalkitsis.uhuruphotos.foundation.dismiss.api.ui.rememberPullToDismissState
import com.savvasdalkitsis.uhuruphotos.foundation.theme.api.window.LocalWindowSize
import com.savvasdalkitsis.uhuruphotos.foundation.ui.api.ui.scaffold.UhuruScaffold
import com.savvasdalkitsis.uhuruphotos.foundation.ui.api.ui.UhuruFullLoading
import com.savvasdalkitsis.uhuruphotos.foundation.ui.api.ui.scaffold.UhuruUpNavButton
import me.saket.telephoto.zoomable.ZoomableState

@Composable
internal fun LightboxScaffold(
    state: LightboxState,
    index: Int,
    action: (LightboxAction) -> Unit,
    zoomableState: ZoomableState,
    scrollState: ScrollState,
) {
    val dismissState = rememberPullToDismissState(
        onDismiss = { action(UpPressed) },
    )
    UhuruScaffold(
        title = { },
        bottomBarContent = {
            AnimatedVisibility(
                visible = LocalWindowSize.current.widthSizeClass == Compact && state.showActionsOverlay,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
            ) {
                LightboxDismissProgressAware(dismissState) {
                    LightboxBottomActionBar(state.media[index], state.showRestoreButton, action)
                }
            }
        },
        actionBarContent = {
            LightboxActionBar(state, index, action, scrollState, dismissState)
        },
        toolbarColor = { Color.Transparent },
        bottomBarColor = { Color.Transparent },
        topBarDisplayed = state.showUI,
        bottomBarDisplayed = state.showUI,
        navigationIcon = {
            LightboxDismissProgressAware(dismissState) {
                UhuruUpNavButton { action(UpPressed) }
            }
        },
    ) { contentPadding ->
        val serverUrl = LocalServerUrl.current
        val mediaItem = state.media[index]
        val thumbnailUri = remember(serverUrl, mediaItem.id) {
            mediaItem.id.thumbnailUri(serverUrl)
        }

        when {
            state.isLoading && thumbnailUri.isEmpty() -> UhuruFullLoading()
            else -> LightboxCanvas(action, state, index, contentPadding, scrollState, zoomableState, dismissState)
        }
    }
}