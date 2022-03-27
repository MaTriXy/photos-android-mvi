package com.savvasdalkitsis.librephotos.photos.module

import com.savvasdalkitsis.librephotos.Database
import com.savvasdalkitsis.librephotos.photos.api.PhotosService
import com.savvasdalkitsis.librephotos.photos.db.PhotoDetailsQueries
import com.savvasdalkitsis.librephotos.photos.db.PhotoSummaryQueries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun photosService(
        retrofit: Retrofit,
    ): PhotosService = retrofit.create(PhotosService::class.java)

    @Provides
    fun photoDetailsQueries(database: Database): PhotoDetailsQueries = database.photoDetailsQueries

    @Provides
    fun photoSummaryQueries(database: Database): PhotoSummaryQueries = database.photoSummaryQueries
}