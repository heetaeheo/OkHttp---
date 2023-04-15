package com.example.okhttpclient.domain

import com.example.okhttpclient.data.WebSocketDataSource
import okhttp3.WebSocketListener

class VideoRepositoryImpl(
    private val webSocketDataSource: WebSocketDataSource
): VideoRepository {
    override fun connect(url: String, listener: WebSocketListener) {
        webSocketDataSource.connect(url,listener)
    }

    override fun disconnect() {
        webSocketDataSource.disconnect()
    }
}