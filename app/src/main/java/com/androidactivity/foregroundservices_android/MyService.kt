package com.androidactivity.foregroundservices_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        when (intent.action) {
            Action.START.name -> start()
            Action.STOP.name -> stop()
        }
        return START_STICKY
    }

    private fun start() {

        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Service has Started")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setOngoing(true)
            .build()

        // Please, create notification channel to show the notification

        startForeground(NOTIFICATION_ID, notification)

        // Add Code you want to start with your service
    }

    private fun stop () {
        stopSelf()
        // Add Code to stop notification
    }
}

enum class Action {
    START,
    STOP
}

const val NOTIFICATION_CHANNEL_ID = "channel_id_one"
const val NOTIFICATION_ID = 1