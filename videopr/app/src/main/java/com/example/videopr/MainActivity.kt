package com.example.videopr

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.ro
        val videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoURI(Uri.parse(videoPath))

        val mediaController = MediaController(this)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            videoView.seekTo(videoView.currentPosition - 10000)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            videoView.seekTo(videoView.currentPosition + 10000)
        }
        val buttonStop: Button = findViewById(R.id.buttonStop)
        buttonStop.setOnClickListener {
            videoView.stopPlayback()
            videoView.setVideoURI(Uri.parse(videoPath))
        }
    }
}