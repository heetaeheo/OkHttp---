package com.example.okhttpclient.domain

import okhttp3.WebSocketListener

interface VideoRepository {
    fun connect(url: String, listener: WebSocketListener)
    fun disconnect()
}