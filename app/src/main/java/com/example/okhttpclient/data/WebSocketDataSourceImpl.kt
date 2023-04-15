package com.example.okhttpclient.data

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketDataSourceImpl(
    private val client: OkHttpClient
): WebSocketDataSource {
    private var webSocket: WebSocket? = null

    override fun connect(url: String, listener: WebSocketListener) {
        val request = Request.Builder().url(url).build()
        webSocket = client.newWebSocket(request, listener)
    }

    override fun disconnect() {
        webSocket?.cancel()
        webSocket = null
    }
}