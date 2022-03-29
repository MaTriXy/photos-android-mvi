package com.savvasdalkitsis.librephotos.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.savvasdalkitsis.librephotos.home.view.state.HomeState
import com.savvasdalkitsis.librephotos.navigation.ControllersProvider

@Composable
fun Home(
    state: HomeState,
    controllersProvider: ControllersProvider,
    imageLoader: ImageLoader,
) {
    HomeScaffold(
        controllersProvider.navController!!,
        content = {
            if (state.isLoading) {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(48.dp))
                }
            }
        },
        imageLoader = imageLoader,
    )
}

