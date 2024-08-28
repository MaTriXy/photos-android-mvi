/*
Copyright 2024 Savvas Dalkitsis

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
package com.savvasdalkitsis.uhuruphotos.feature.album.auto.view.implementation.seam.action

import com.savvasdalkitsis.uhuruphotos.feature.album.auto.view.implementation.seam.AutoAlbumActionsContext
import com.savvasdalkitsis.uhuruphotos.feature.album.auto.view.implementation.seam.AutoAlbumMutation.SetAlbumId
import com.savvasdalkitsis.uhuruphotos.feature.album.auto.view.implementation.ui.state.AutoAlbumState
import kotlinx.coroutines.flow.flowOf

data class SetAlbumId(val id: Int) : AutoAlbumAction() {
    context(AutoAlbumActionsContext)
    override fun handle(state: AutoAlbumState) =
        flowOf(SetAlbumId(id))
}
