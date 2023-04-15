package com.example.okhttpclient.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.okhttpclient.domain.VideoRepository
import com.google.android.exoplayer2.ExoPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val videoRepository: VideoRepository,
    @ApplicationContext private val context: Context
): ViewModel() {

    private val player: ExoPlayer = ExoPlayer.Builder(context).build()

    fun getPlayer(): ExoPlayer{
        return player
    }

    fun connectToWebSocket(url: String){
        val listener = object : WebSocketListener(){
            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
            }
        }
        videoRepository.connect(url,listener)
    }

    fun disconnectFromWebSocket(){
        videoRepository.disconnect()
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }

}