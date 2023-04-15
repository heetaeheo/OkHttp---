package com.example.okhttpclient.di

import com.example.okhttpclient.data.WebSocketDataSource
import com.example.okhttpclient.data.WebSocketDataSourceImpl
import com.example.okhttpclient.domain.VideoRepository
import com.example.okhttpclient.domain.VideoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideWebSocketDataSource(client: OkHttpClient): WebSocketDataSource {
        return WebSocketDataSourceImpl(client)
    }
    @Provides
    fun provideVideoRepository(webSocketDataSource:WebSocketDataSource): VideoRepository {
        return VideoRepositoryImpl(webSocketDataSource)
    }



}