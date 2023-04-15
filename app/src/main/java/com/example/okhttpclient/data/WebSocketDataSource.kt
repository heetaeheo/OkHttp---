package com.example.okhttpclient.data

import okhttp3.WebSocketListener

interface WebSocketDataSource {
    fun connect(url: String, listener: WebSocketListener)
    fun disconnect()
}