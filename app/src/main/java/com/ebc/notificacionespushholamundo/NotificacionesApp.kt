package com.ebc.notificacionespushholamundo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

class NotificacionesApp: Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val ID_CHANNEL = "1234"

        val NAME = "mi_primer_canal"

        val notificationChannel =
            NotificationChannel(ID_CHANNEL, NAME, NotificationManager.IMPORTANCE_HIGH)

        notificationChannel.description = "Este es mi primer canal de notificaciones"

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(notificationChannel)

        println("Aplication listo")

    }
}