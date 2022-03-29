package com.savvasdalkitsis.librephotos.userbadge.usecase

import androidx.work.WorkInfo
import androidx.work.WorkInfo.State.*
import com.savvasdalkitsis.librephotos.albums.worker.AlbumDownloadWorker
import com.savvasdalkitsis.librephotos.photos.usecase.PhotosUseCase
import com.savvasdalkitsis.librephotos.user.usecase.UserUseCase
import com.savvasdalkitsis.librephotos.userbadge.view.state.SyncState.*
import com.savvasdalkitsis.librephotos.userbadge.view.state.UserBadgeState
import com.savvasdalkitsis.librephotos.worker.usecase.WorkerStatusUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class UserBadgeUseCase @Inject constructor(
    private val userUseCase: UserUseCase,
    private val workerStatusUseCase: WorkerStatusUseCase,
    private val photosUseCase: PhotosUseCase,
) {

    fun getUserBadgeState(): Flow<UserBadgeState> = userUseCase.getUser()
        .combine(workerStatusUseCase.monitorUniqueJobStatus(AlbumDownloadWorker.ONE_OFF_WORK_NAME)
            .combine(workerStatusUseCase.monitorUniqueJobStatus(AlbumDownloadWorker.PERIODIC_WORK_NAME))
            { a, b -> a + b })
        { user, status ->
            UserBadgeState(
                avatarUrl = with(photosUseCase) { user.avatar?.toAbsoluteUrl() },
                syncState = when (status) {
                    BLOCKED, CANCELLED, FAILED -> BAD
                    ENQUEUED, SUCCEEDED -> GOOD
                    RUNNING -> IN_PROGRESS
                },
                initials = user.firstName.initial() + user.lastName.initial()
            )
        }

    private fun String?.initial() =
        orEmpty().firstOrNull()?.toString()?.uppercase() ?: ""
}

private operator fun WorkInfo.State.plus(other: WorkInfo.State): WorkInfo.State {
    if (this == RUNNING || other == RUNNING) return RUNNING
    if (this == FAILED || other == FAILED) return FAILED
    if (this == SUCCEEDED && other == SUCCEEDED) return SUCCEEDED
    return this
}
