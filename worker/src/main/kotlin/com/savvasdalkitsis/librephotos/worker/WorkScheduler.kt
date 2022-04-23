package com.savvasdalkitsis.librephotos.worker

import androidx.work.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WorkScheduler @Inject constructor(
    val workManager: WorkManager,
) {
    inline fun <reified W: CoroutineWorker> scheduleNow(
        workName: String,
        backoffPolicy: BackoffPolicy = BackoffPolicy.EXPONENTIAL,
        backoffDelay: Long = 1,
        backoffTimeUnit: TimeUnit = TimeUnit.MINUTES,
        networkRequirement: NetworkType = NetworkType.CONNECTED,
        params: Data.Builder.() -> Data.Builder = { this },
    ) {
        workManager.enqueueUniqueWork(
            workName,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequestBuilder<W>()
                .setInputData(params(Data.Builder()).build())
                .setBackoffCriteria(backoffPolicy, backoffDelay, backoffTimeUnit)
                .setConstraints(Constraints.Builder()
                    .setRequiredNetworkType(networkRequirement)
                    .build())
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .build(),
        )
    }

    inline fun <reified W: CoroutineWorker> schedulePeriodic(
        workName: String,
        repeatInterval: Long,
        repeatIntervalTimeUnit: TimeUnit,
        initialDelayDuration: Long,
        initialDelayTimeUnit: TimeUnit,
        backoffPolicy: BackoffPolicy = BackoffPolicy.EXPONENTIAL,
        backoffDelay: Long = 1,
        backoffTimeUnit: TimeUnit = TimeUnit.MINUTES,
        networkRequirement: NetworkType = NetworkType.CONNECTED,
        existingPeriodicWorkPolicy: ExistingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE,
    ) {
        workManager.enqueueUniquePeriodicWork(
            workName,
            existingPeriodicWorkPolicy,
            PeriodicWorkRequestBuilder<W>(repeatInterval, repeatIntervalTimeUnit)
                .setInitialDelay(initialDelayDuration, initialDelayTimeUnit)
                .setBackoffCriteria(backoffPolicy, backoffDelay, backoffTimeUnit)
                .setConstraints(Constraints.Builder()
                    .setRequiredNetworkType(networkRequirement)
                    .build())
                .build(),
        )
    }

    fun cancelAllScheduledWork() {
        workManager.cancelAllWork()
    }
}