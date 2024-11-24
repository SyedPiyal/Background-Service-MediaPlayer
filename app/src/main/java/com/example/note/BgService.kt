package com.example.note

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.MediaPlayer
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat

class BgService : Service() {

    private lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping = true
        player.start()
        // Create the foreground notification
        val notification = createNotification()

        // Start the service in the foreground
        startForeground(1, notification)


        return START_STICKY
    }

    // Helper function to create the notification
    private fun createNotification(): Notification {
        val notificationChannelId = "BgServiceChannel"

        // Create notification channel for devices running Android O or later
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(
                notificationChannelId,
                "Background Service",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Create the notification
        return NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle("Background Service")
            .setContentText("The background service is running.")
            .setSmallIcon(R.drawable.baseline_pie_chart_24)  // Replace with your own icon
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        //stop player
        player.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}