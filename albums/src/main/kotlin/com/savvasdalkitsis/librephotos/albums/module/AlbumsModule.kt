package com.savvasdalkitsis.librephotos.albums.module

import com.savvasdalkitsis.librephotos.albums.service.AlbumsService
import com.savvasdalkitsis.librephotos.db.albums.AlbumsQueries
import com.savvasdalkitsis.librephotos.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class AlbumsModule {

    @Provides
    fun albumsService(
        retrofit: Retrofit,
    ): AlbumsService = retrofit.create(AlbumsService::class.java)


    @Provides
    fun albumsQueries(database: Database): AlbumsQueries = database.albumsQueries
}