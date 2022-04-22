package com.savvasdalkitsis.librephotos.albums.api.worker

import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkInfo
import kotlinx.coroutines.flow.Flow

interface AlbumWorkScheduler {

    fun scheduleAlbumsRefreshNow(shallow: Boolean)
    fun scheduleAlbumsRefreshPeriodic(
        hoursInterval: Int,
        existingPeriodicWorkPolicy: ExistingPeriodicWorkPolicy
    )
    fun observeAlbumRefreshJobStatus(): Flow<WorkInfo.State>
}